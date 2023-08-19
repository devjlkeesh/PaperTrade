package dev.jlkeesh.papertrade.dao;

import dev.jlkeesh.papertrade.criteria.GenericCriteria;
import dev.jlkeesh.papertrade.domains.BaseDomain;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * @author : Elmurodov Javohir
 * @since : 01/06/23 / 17:27
 */

@Slf4j
public abstract class GenericDao<T extends BaseDomain, ID extends Serializable, C extends GenericCriteria> {

    @Autowired
    protected EntityManager em;

    protected final Class<T> persistentClass;
    protected JpaEntityInformation<T, ?> entityInformation;


    @SuppressWarnings("unchecked")
    protected GenericDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @PostConstruct
    private void initEntityInformation() {
        if (em != null && entityInformation == null) {
            this.entityInformation = JpaEntityInformationSupport.getEntityInformation(persistentClass, em);
        }
    }

    @Transactional(timeout = 5)
    public T save(T domain) {
        Assert.notNull(domain, "Entity must not be null");

        if (entityInformation.isNew(domain)) {
            em.persist(domain);
            return domain;
        } else {
            return em.merge(domain);
        }
    }

    @Transactional
    public List<T> save(Iterable<T> domains) {
        Assert.notNull(domains, "Entities must not be null");

        List<T> result = new ArrayList<>();

        for (T entity : domains) {
            result.add(save(entity));
        }
        return result;
    }

    @Transactional
    public void update(Iterable<T> domains) {
        Assert.notNull(domains, "Entities must not be null");
        for (T entity : domains) save(entity);
    }

    @Transactional(timeout = 2)
    public boolean delete(ID id) {
        Assert.notNull(id, "The given id must not be null");
        try {
            Query query = em.createQuery("update " + persistentClass.getSimpleName() + " t set t.deleted = true where t.deleted = false and t.id = " + id);
            return query.executeUpdate() != 0;
        } catch (PersistenceException ex) {
            log.error("JPA Error : ", ex);
        }
        return false;
    }

    @Transactional(readOnly = true, timeout = 3)
    public Optional<T> find(ID id) {

        Assert.notNull(id, "The given id must not be null");

        try {
            return Optional.of(em.createQuery("select t from " + persistentClass.getSimpleName() + " t where t.deleted = false and t.id =  " + id, persistentClass)
                    .getSingleResult());
        } catch (PersistenceException ex) {
            log.error("JPA Error : ", ex);
            return Optional.empty();
        }
    }


    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, timeout = 5)
    public Optional<T> find(C criteria) {
        try {
            Query query = findInit(criteria, false);
            return Optional.ofNullable(((T) query.getSingleResult()));
        } catch (PersistenceException ex) {
            return Optional.empty();
        }
    }

    @Transactional(readOnly = true, timeout = 10)
    public List<T> findAll(C criteria) {
        try {
            return findAllGeneric(criteria);
        } catch (PersistenceException ex) {
            log.info("JPA Error : ", ex);
        }
        return Collections.emptyList();
    }

    @Transactional(readOnly = true, timeout = 10)
    public Long getTotalCount(C criteria) {
        Query query = findInit(criteria, true);
        return (Long) query.getSingleResult();
    }

    protected List<Object[]> getAllCustomDtoList(C criteria) {
        return findAllGeneric(criteria);
    }

    protected <G> List<G> findAllGeneric(C criteria) {
        Query query = findInit(criteria, false);
        return getResults(criteria, query);
    }


    private Query findInit(C criteria, boolean onDefineCount) {
        Query query;
        Map<String, Object> params = new HashMap<>();
        List<String> whereCause = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder();

        defineCriteriaOnQuerying(criteria, whereCause, params, queryBuilder);

        query = defineQuerySelect(criteria, queryBuilder, onDefineCount);

        defineSetterParams(query, params);

        return query;
    }

    protected void defineCriteriaOnQuerying(C criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }

    @SuppressWarnings("unused")
    protected void onDefineWhereCause(C criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (!whereCause.isEmpty())
            queryBuilder.append(" and ").append(StringUtils.collectionToDelimitedString(whereCause, " and "));
    }

    private void defineSetterParams(Query query, Map<String, Object> params) {
        params.forEach(query::setParameter);
    }

    protected Query defineQuerySelect(C criteria, StringBuilder queryBuilder, boolean onDefineCount) {
        String queryStr = " select " + (onDefineCount ? " count(t) " : " t ") + " from " + persistentClass.getSimpleName() + " t " +
                joinStringOnQuerying(criteria) + " where t.deleted = false " + queryBuilder + (onDefineCount ? "" : onSortBy(criteria).toString());
        return onDefineCount ? em.createQuery(queryStr, Long.class) : em.createQuery(queryStr);
    }

    @SuppressWarnings("unused")
    protected StringBuilder joinStringOnQuerying(C criteria) {
        return new StringBuilder();
    }

    protected StringBuilder onSortBy(C criteria) {
        StringBuilder sorting = new StringBuilder();
        if (StringUtils.hasText(criteria.getSortBy())) {
            String ascDesc = criteria.getSortDirection();
            sorting.append(" order by ").append("t.").append(criteria.getSortBy()).append(" ").append(ascDesc);
        }
        return sorting;
    }

    @SuppressWarnings("unchecked")
    protected <G> List<G> getResults(C criteria, Query query) {
        return isPaged(criteria)
                ? query.setFirstResult(criteria.getPage() * criteria.getSize()).setMaxResults(criteria.getSize()).getResultList()
                : query.getResultList();
    }

    private boolean isPaged(C criteria) {
        if ((criteria.getPage() == null || criteria.getSize() == null))
            return false;
        return criteria.getPage() >= 0 && criteria.getSize() > 0;
    }

/*    private String idField() {
        var idAttribute = entityInformation.getIdAttribute();
        return idAttribute == null ? "id" : idAttribute.getName();
    }*/

}

package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class ManufacturerRepositoryImpl extends GenericDao<Manufacturer, Long, ManufacturerCriteria> implements ManufacturerRepository {

    @Override
    protected void defineCriteriaOnQuerying(ManufacturerCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getName())) {
            whereCause.add(" lower(t.name) like :name");
            params.put("name", "%" + criteria.getName().toLowerCase() + "%");
        }
        if (BaseUtils.isNotEmpty(criteria.getState())) {
            whereCause.add("t.state = :state");
            params.put("state", criteria.getState());
        }
        if (BaseUtils.isNotEmpty(criteria.getCountryId())) {
            whereCause.add("t.country.id = :countryId");
            params.put("countryId", criteria.getCountryId());
        }
        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

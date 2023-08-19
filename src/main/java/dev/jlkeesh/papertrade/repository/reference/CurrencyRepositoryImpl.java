package dev.jlkeesh.papertrade.repository.reference;


import dev.jlkeesh.papertrade.criteria.CurrencyCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class CurrencyRepositoryImpl extends GenericDao<Currency, Long, CurrencyCriteria> implements CurrencyRepository {

    @Override
    protected void defineCriteriaOnQuerying(CurrencyCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getName())) {
            whereCause.add(" lower(t.name) like :name");
            params.put("name", "%" + criteria.getName().toLowerCase() + "%");
        }

        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

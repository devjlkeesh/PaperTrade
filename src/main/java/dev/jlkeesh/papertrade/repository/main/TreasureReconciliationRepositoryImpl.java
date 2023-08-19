package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TreasureReconciliationCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.TreasureReconciliation;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class TreasureReconciliationRepositoryImpl extends GenericDao<TreasureReconciliation, Long, TreasureReconciliationCriteria> implements TreasureReconciliationRepository {

    @Override
    protected void defineCriteriaOnQuerying(TreasureReconciliationCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getCurrencyId())) {
            whereCause.add("t.currency.id = :currencyId");
            params.put("currencyId", criteria.getCurrencyId());
        }
        if (BaseUtils.isNotEmpty(criteria.getTreasureSourceId())) {
            whereCause.add("t.treasureSource.id = :treasureSourceId");
            params.put("treasureSourceId", criteria.getTreasureSourceId());
        }
        if (BaseUtils.isNotEmpty(criteria.getBeginDate())) {
            whereCause.add("t.beginDate >= :beginDate");
            params.put("beginDate", criteria.getBeginDate());
        }
        if (BaseUtils.isNotEmpty(criteria.getEndDate())) {
            whereCause.add("t.endDate <= :endDate");
            params.put("endDate", criteria.getEndDate());
        }

        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

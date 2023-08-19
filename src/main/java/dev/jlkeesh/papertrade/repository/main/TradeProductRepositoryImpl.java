package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TradeProductCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.TradeProduct;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class TradeProductRepositoryImpl extends GenericDao<TradeProduct, Long, TradeProductCriteria> implements TradeProductRepository {

    @Override
    protected void defineCriteriaOnQuerying(TradeProductCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getBarCode())) {
            whereCause.add("t.barCode = :barCode");
            params.put("barCode", criteria.getBarCode());
        }
        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

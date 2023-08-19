package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TradeCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.Trade;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class TradeRepositoryImpl extends GenericDao<Trade, Long, TradeCriteria> implements TradeRepository {

    @Override
    protected void defineCriteriaOnQuerying(TradeCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getTradeStatusId())) {
            whereCause.add("t.tradeStatus.id = :tradeStatusId");
            params.put("tradeStatusId", criteria.getTradeStatusId());
        }
        if (BaseUtils.isNotEmpty(criteria.getCustomerId())) {
            whereCause.add("t.customer.id = :customerId");
            params.put("customerId", criteria.getCustomerId());
        }
        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

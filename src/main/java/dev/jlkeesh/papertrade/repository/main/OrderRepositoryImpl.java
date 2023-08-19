package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.OrderCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.Order;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:51
 */

@Repository
public class OrderRepositoryImpl extends GenericDao<Order, Long, OrderCriteria> implements OrderRepository {

    @Override
    protected void defineCriteriaOnQuerying(OrderCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
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

package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPayment;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:49
 */

@Repository
public class ManufacturerPaymentRepositoryImpl extends GenericDao<ManufacturerPayment, Long, ManufacturerPaymentCriteria> implements ManufacturerPaymentRepository {
    @Override
    protected void defineCriteriaOnQuerying(ManufacturerPaymentCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getManufacturerId())) {
            whereCause.add("t.manufacturer.id = :manufacturerId");
            params.put("manufacturerId", criteria.getManufacturerId());
        }
        if (BaseUtils.isNotEmpty(criteria.getOrderWagonId())) {
            whereCause.add("t.orderWagon.id = :orderWagonId");
            params.put("orderWagonId", criteria.getOrderWagonId());
        }

        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

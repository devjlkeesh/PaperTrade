package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductsReconciliationCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.InventoryProductsReconciliation;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class InventoryProductsReconciliationRepositoryImpl extends GenericDao<InventoryProductsReconciliation, Long, InventoryProductsReconciliationCriteria> implements InventoryProductsReconciliationRepository {

    @Override
    protected void defineCriteriaOnQuerying(InventoryProductsReconciliationCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getInventoryId())) {
            whereCause.add("t.inventory.id = :inventoryId");
            params.put("inventoryId", criteria.getInventoryId());
        }
        if (BaseUtils.isNotEmpty(criteria.getProductId())) {
            whereCause.add("t.product.id = :productId");
            params.put("productId", criteria.getProductId());
        }
        if (BaseUtils.isNotEmpty(criteria.getManufacturerId())) {
            whereCause.add("t.manufacturer.id = :manufacturerId");
            params.put("manufacturerId", criteria.getManufacturerId());
        }

        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

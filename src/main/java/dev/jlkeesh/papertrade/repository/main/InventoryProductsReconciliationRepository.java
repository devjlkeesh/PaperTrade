package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductsReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.InventoryProductsReconciliation;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface InventoryProductsReconciliationRepository extends GenericCrudRepository<InventoryProductsReconciliation, Long, InventoryProductsReconciliationCriteria> {
}

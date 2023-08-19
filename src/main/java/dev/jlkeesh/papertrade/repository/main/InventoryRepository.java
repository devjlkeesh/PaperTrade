package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.InventoryCriteria;
import dev.jlkeesh.papertrade.domains.main.Inventory;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface InventoryRepository extends GenericCrudRepository<Inventory, Long, InventoryCriteria> {
}

package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductCriteria;
import dev.jlkeesh.papertrade.domains.main.InventoryProduct;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 11:08
 */

public interface InventoryProductRepository extends GenericCrudRepository<InventoryProduct, Long, InventoryProductCriteria> {
}

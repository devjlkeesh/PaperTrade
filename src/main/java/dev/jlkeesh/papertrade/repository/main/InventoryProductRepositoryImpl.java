package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.InventoryProduct;
import org.springframework.stereotype.Repository;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 11:09
 */

@Repository
public class InventoryProductRepositoryImpl extends GenericDao<InventoryProduct, Long, InventoryProductCriteria> implements InventoryProductRepository {
}

package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ProductPriceCriteria;
import dev.jlkeesh.papertrade.domains.main.ProductPrice;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface ProductPriceRepository extends GenericCrudRepository<ProductPrice, Long, ProductPriceCriteria> {
}

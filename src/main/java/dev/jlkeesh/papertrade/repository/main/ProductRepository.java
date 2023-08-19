package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ProductCriteria;
import dev.jlkeesh.papertrade.domains.main.Product;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface ProductRepository extends GenericCrudRepository<Product, Long, ProductCriteria> {
}

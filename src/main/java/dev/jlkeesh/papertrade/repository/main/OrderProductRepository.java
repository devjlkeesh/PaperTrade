package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.OrderProductCriteria;
import dev.jlkeesh.papertrade.domains.main.OrderProduct;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 18:51
 */

public interface OrderProductRepository extends GenericCrudRepository<OrderProduct, Long, OrderProductCriteria> {
}

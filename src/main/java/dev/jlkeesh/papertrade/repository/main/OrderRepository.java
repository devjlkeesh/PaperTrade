package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.OrderCriteria;
import dev.jlkeesh.papertrade.domains.main.Order;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:45
 */
public interface OrderRepository extends GenericCrudRepository<Order, Long, OrderCriteria> {
}

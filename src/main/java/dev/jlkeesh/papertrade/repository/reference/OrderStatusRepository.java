package dev.jlkeesh.papertrade.repository.reference;

import dev.jlkeesh.papertrade.criteria.OrderStatusCriteria;
import dev.jlkeesh.papertrade.domains.reference.OrderStatus;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface OrderStatusRepository extends GenericCrudRepository<OrderStatus, Long, OrderStatusCriteria> {
}

package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.OrderWagonCriteria;
import dev.jlkeesh.papertrade.domains.main.OrderWagon;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:20
 */

public interface OrderWagonRepository extends GenericCrudRepository<OrderWagon, Long, OrderWagonCriteria> {
}

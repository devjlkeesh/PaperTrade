package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.CustomerCriteria;
import dev.jlkeesh.papertrade.domains.main.Customer;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface CustomerRepository extends GenericCrudRepository<Customer, Long, CustomerCriteria> {
}

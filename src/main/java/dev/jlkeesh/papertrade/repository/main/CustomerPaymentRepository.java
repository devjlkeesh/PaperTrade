package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.CustomerPaymentCriteria;
import dev.jlkeesh.papertrade.domains.main.CustomerPayment;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:09
 */

public interface CustomerPaymentRepository extends GenericCrudRepository<CustomerPayment, Long, CustomerPaymentCriteria> {
}

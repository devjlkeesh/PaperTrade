package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.CustomerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.CustomerPaymentReconciliation;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:37
 */

@Repository
public interface CustomerPaymentReconciliationRepository extends GenericCrudRepository<CustomerPaymentReconciliation, Long, CustomerPaymentReconciliationCriteria> {
}

package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliation;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:49
 */
public interface ManufacturerPaymentReconciliationRepository extends GenericCrudRepository<ManufacturerPaymentsReconciliation, Long, ManufacturerPaymentReconciliationCriteria> {
}

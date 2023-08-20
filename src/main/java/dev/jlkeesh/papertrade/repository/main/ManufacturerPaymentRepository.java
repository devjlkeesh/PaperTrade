package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentCriteria;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPayment;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:49
 */
public interface ManufacturerPaymentRepository extends GenericCrudRepository<ManufacturerPayment, Long, ManufacturerPaymentCriteria> {
}

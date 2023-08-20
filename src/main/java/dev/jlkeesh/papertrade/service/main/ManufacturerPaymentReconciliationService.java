package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliationUpdateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentsReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentsReconciliationDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:51
 */
public interface ManufacturerPaymentReconciliationService extends GenericCrudService<ManufacturerPaymentsReconciliationDto, ManufacturerPaymentsReconciliationCreateDto, ManufacturerPaymentsReconciliationUpdateDto, ManufacturerPaymentReconciliationCriteria, Long> {
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CustomerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconcilationDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconciliationUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:39
 */

public interface CustomerPaymentReconciliationService extends GenericCrudService<CustomerPaymentReconcilationDto, CustomerPaymentReconciliationCreateDto, CustomerPaymentReconciliationUpdateDto, CustomerPaymentReconciliationCriteria, Long> {
}

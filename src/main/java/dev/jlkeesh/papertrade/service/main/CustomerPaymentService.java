package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CustomerPaymentCriteria;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:11
 */
public interface CustomerPaymentService extends GenericCrudService<CustomerPaymentDto, CustomerPaymentCreateDto, CustomerPaymentUpdateDto, CustomerPaymentCriteria, Long> {
}

package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.CustomerPayment;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:06
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CustomerPaymentMapper extends BaseMapper<CustomerPayment, CustomerPaymentDto, CustomerPaymentCreateDto, CustomerPaymentUpdateDto> {
}

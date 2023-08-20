package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.CustomerPaymentReconciliation;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconcilationDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconciliationUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:36
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CustomerPaymentReconciliationMapper extends BaseMapper<CustomerPaymentReconciliation, CustomerPaymentReconcilationDto, CustomerPaymentReconciliationCreateDto, CustomerPaymentReconciliationUpdateDto> {
}

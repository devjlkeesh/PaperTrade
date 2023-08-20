package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.ManufacturerPayment;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import dev.jlkeesh.papertrade.mapper.main.ConsigneeMapper;
import dev.jlkeesh.papertrade.mapper.main.ManufacturerMapper;
import dev.jlkeesh.papertrade.mapper.main.OrderWagonMapper;
import dev.jlkeesh.papertrade.mapper.reference.CountryMapper;
import dev.jlkeesh.papertrade.mapper.reference.CurrencyMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CountryMapper.class, ManufacturerMapper.class, OrderWagonMapper.class, ConsigneeMapper.class, CurrencyMapper.class})
public interface ManufacturerPaymentMapper extends BaseMapper<ManufacturerPayment, ManufacturerPaymentDto, ManufacturerPaymentCreateDto, ManufacturerPaymentUpdateDto> {
}
package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliation;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliationUpdateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentsReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentsReconciliationDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ManufacturerPaymentReconciliationMapper extends BaseMapper<ManufacturerPaymentsReconciliation, ManufacturerPaymentsReconciliationDto, ManufacturerPaymentsReconciliationCreateDto, ManufacturerPaymentsReconciliationUpdateDto> {
}
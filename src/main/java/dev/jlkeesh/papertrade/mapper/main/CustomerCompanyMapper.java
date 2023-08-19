package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.CustomerCompany;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyDto;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerCompanyMapper extends BaseMapper<CustomerCompany, CustomerCompanyDto, CustomerCompanyCreateDto, CustomerCompanyUpdateDto> {
}
package dev.jlkeesh.papertrade.mapper;

import dev.jlkeesh.papertrade.domains.main.Customer;
import dev.jlkeesh.papertrade.dto.main.CustomerCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerDto;
import dev.jlkeesh.papertrade.dto.main.CustomerUpdateDto;
import dev.jlkeesh.papertrade.mapper.reference.RegionMapper;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {RegionMapper.class})
public interface CustomerMapper extends BaseMapper<Customer,CustomerDto, CustomerCreateDto, CustomerUpdateDto> {
}
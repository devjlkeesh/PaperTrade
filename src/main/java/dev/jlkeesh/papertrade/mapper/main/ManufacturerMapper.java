package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.dto.main.ManufacturerCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ManufacturerMapper extends BaseMapper<Manufacturer, ManufacturerDto,ManufacturerCreateDto, ManufacturerUpdateDto> {
}
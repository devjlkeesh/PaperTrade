package dev.jlkeesh.papertrade.mapper.reference;

import dev.jlkeesh.papertrade.domains.reference.Parameter;
import dev.jlkeesh.papertrade.dto.reference.ParameterCreateDto;
import dev.jlkeesh.papertrade.dto.reference.ParameterDto;
import dev.jlkeesh.papertrade.dto.reference.ParameterUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ParameterMapper extends BaseMapper<Parameter, ParameterDto, ParameterCreateDto, ParameterUpdateDto> {
}

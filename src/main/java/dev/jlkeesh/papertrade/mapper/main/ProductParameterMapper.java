package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.ProductParameter;
import dev.jlkeesh.papertrade.dto.main.ProductParameterCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductParameterDto;
import dev.jlkeesh.papertrade.dto.main.ProductParameterUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductParameterMapper extends BaseMapper<ProductParameter, ProductParameterDto, ProductParameterCreateDto, ProductParameterUpdateDto> {
}

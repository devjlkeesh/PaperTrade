package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.Product;
import dev.jlkeesh.papertrade.dto.main.ProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductDto;
import dev.jlkeesh.papertrade.dto.main.ProductUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductMapper extends BaseMapper<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {
}

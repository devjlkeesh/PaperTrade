package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.ProductPrice;
import dev.jlkeesh.papertrade.dto.main.ProductPriceCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductPriceDto;
import dev.jlkeesh.papertrade.dto.main.ProductPriceUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProductPriceMapper extends BaseMapper<ProductPrice, ProductPriceDto, ProductPriceCreateDto, ProductPriceUpdateDto> {
}

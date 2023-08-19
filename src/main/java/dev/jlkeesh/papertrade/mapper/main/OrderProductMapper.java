package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.OrderProduct;
import dev.jlkeesh.papertrade.dto.main.OrderProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderProductDto;
import dev.jlkeesh.papertrade.dto.main.OrderProductUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 18:50
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderProductMapper extends BaseMapper<OrderProduct, OrderProductDto, OrderProductCreateDto, OrderProductUpdateDto> {
}

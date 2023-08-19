package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.Order;
import dev.jlkeesh.papertrade.dto.main.OrderCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderDto;
import dev.jlkeesh.papertrade.dto.main.OrderUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:57
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends BaseMapper<Order, OrderDto, OrderCreateDto, OrderUpdateDto> {
}

package dev.jlkeesh.papertrade.mapper.reference;

import dev.jlkeesh.papertrade.domains.reference.OrderStatus;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusCreateDto;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusDto;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderStatusMapper extends BaseMapper<OrderStatus, OrderStatusDto, OrderStatusCreateDto, OrderStatusUpdateDto> {
}

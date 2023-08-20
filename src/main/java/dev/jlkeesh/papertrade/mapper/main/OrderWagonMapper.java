package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.OrderWagon;
import dev.jlkeesh.papertrade.dto.main.OrderWagonCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderWagonDto;
import dev.jlkeesh.papertrade.dto.main.OrderWagonUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.*;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:19
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderWagonMapper extends BaseMapper<OrderWagon, OrderWagonDto, OrderWagonCreateDto, OrderWagonUpdateDto> {
    OrderWagon toEntity(OrderWagonDto orderWagonDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderWagon partialUpdate(OrderWagonDto orderWagonDto, @MappingTarget OrderWagon orderWagon);
}

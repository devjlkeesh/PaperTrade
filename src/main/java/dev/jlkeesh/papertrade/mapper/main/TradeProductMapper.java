package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.TradeProduct;
import dev.jlkeesh.papertrade.dto.main.TradeProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.TradeProductDto;
import dev.jlkeesh.papertrade.dto.main.TradeProductUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TradeProductMapper extends BaseMapper<TradeProduct, TradeProductDto, TradeProductCreateDto, TradeProductUpdateDto> {
}

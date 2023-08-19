package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.Trade;
import dev.jlkeesh.papertrade.dto.main.TradeCreateDto;
import dev.jlkeesh.papertrade.dto.main.TradeDto;
import dev.jlkeesh.papertrade.dto.main.TradeUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TradeMapper extends BaseMapper<Trade, TradeDto, TradeCreateDto, TradeUpdateDto> {
}

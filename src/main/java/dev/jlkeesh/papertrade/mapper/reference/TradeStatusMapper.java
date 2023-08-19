package dev.jlkeesh.papertrade.mapper.reference;

import dev.jlkeesh.papertrade.domains.reference.TradeStatus;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusCreateDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TradeStatusMapper extends BaseMapper<TradeStatus, TradeStatusDto, TradeStatusCreateDto, TradeStatusUpdateDto> {
}

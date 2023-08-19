package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.TreasureSource;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceDto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TreasureSourceMapper extends BaseMapper<TreasureSource, TreasureSourceDto, TreasureSourceCreateDto, TreasureSourceUpdateDto> {
}

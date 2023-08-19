package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.Treasury;
import dev.jlkeesh.papertrade.dto.main.TreasuryCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasuryDto;
import dev.jlkeesh.papertrade.dto.main.TreasuryUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:47
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TreasuryMapper extends BaseMapper<Treasury, TreasuryDto, TreasuryCreateDto, TreasuryUpdateDto> {
}

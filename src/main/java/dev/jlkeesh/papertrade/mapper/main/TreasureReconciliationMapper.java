package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.TreasureReconciliation;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TreasureReconciliationMapper extends BaseMapper<TreasureReconciliation, TreasureReconciliationDto, TreasureReconciliationCreateDto, TreasureReconciliationUpdateDto> {
}

package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.InventoryProductsReconciliation;
import dev.jlkeesh.papertrade.dto.main.InventoryProductReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductReconciliationUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InventoryProductsReconciliationMapper extends BaseMapper<InventoryProductsReconciliation, InventoryProductReconciliationDto, InventoryProductReconciliationCreateDto, InventoryProductReconciliationUpdateDto> {
}

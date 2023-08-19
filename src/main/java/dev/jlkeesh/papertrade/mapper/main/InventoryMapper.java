package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.Inventory;
import dev.jlkeesh.papertrade.dto.main.InventoryCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryDto;
import dev.jlkeesh.papertrade.dto.main.InventoryUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InventoryMapper extends BaseMapper<Inventory, InventoryDto, InventoryCreateDto, InventoryUpdateDto> {
}

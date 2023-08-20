package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.InventoryProduct;
import dev.jlkeesh.papertrade.dto.main.InventoryProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 11:05
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryProductMapper extends BaseMapper<InventoryProduct, InventoryProductDto, InventoryProductCreateDto, InventoryProductUpdateDto> {
}

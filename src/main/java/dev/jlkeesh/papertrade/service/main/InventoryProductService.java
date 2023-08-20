package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductCriteria;
import dev.jlkeesh.papertrade.dto.main.InventoryProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 11:10
 */
public interface InventoryProductService extends GenericCrudService<InventoryProductDto, InventoryProductCreateDto, InventoryProductUpdateDto, InventoryProductCriteria, Long> {
}

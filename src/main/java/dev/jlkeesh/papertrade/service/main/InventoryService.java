package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.InventoryCriteria;
import dev.jlkeesh.papertrade.dto.main.InventoryCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryDto;
import dev.jlkeesh.papertrade.dto.main.InventoryUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface InventoryService extends GenericCrudService<InventoryDto, InventoryCreateDto, InventoryUpdateDto, InventoryCriteria, Long> {
}

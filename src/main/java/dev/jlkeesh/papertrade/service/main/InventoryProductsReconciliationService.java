package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductsReconciliationCriteria;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface InventoryProductsReconciliationService extends GenericCrudService<InventoryProductsReconciliationDto, InventoryProductsReconciliationCreateDto, InventoryProductsReconciliationUpdateDto, InventoryProductsReconciliationCriteria, Long> {
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductsReconciliationCriteria;
import dev.jlkeesh.papertrade.dto.main.InventoryProductReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductReconciliationUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface InventoryProductsReconciliationService extends GenericCrudService<InventoryProductReconciliationDto, InventoryProductReconciliationCreateDto, InventoryProductReconciliationUpdateDto, InventoryProductsReconciliationCriteria, Long> {
}

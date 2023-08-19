package dev.jlkeesh.papertrade.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:04
 */
@Getter
@Setter
@ParameterObject
public class InventoryProductsReconciliationCriteria extends GenericCriteria {
    private Long productId;
    private Long inventoryId;
    private Long manufacturerId;

    @Builder(builderMethodName = "childBuilder")
    public InventoryProductsReconciliationCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long productId, Long inventoryId, Long manufacturerId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.productId = productId;
        this.inventoryId = inventoryId;
        this.manufacturerId = manufacturerId;
    }
}

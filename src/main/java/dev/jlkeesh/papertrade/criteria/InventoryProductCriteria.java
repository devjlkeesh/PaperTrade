package dev.jlkeesh.papertrade.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 10:59
 */

@Getter
@Setter
@ParameterObject
public class InventoryProductCriteria extends GenericCriteria{
    private Long inventoryId;
    private Long productId;
    private Long manufacturerId;
    private Long tradeProductId;

    @Builder(builderMethodName = "childBuilder")
    public InventoryProductCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long inventoryId, Long productId, Long manufacturerId, Long tradeProductId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.manufacturerId = manufacturerId;
        this.tradeProductId = tradeProductId;
    }
}

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
public class ProductPriceCriteria extends GenericCriteria {
    private Long productId;
    private Long manufacturerId;
    @Builder(builderMethodName = "childBuilder")
    public ProductPriceCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long productId, Long manufacturerId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.productId = productId;
        this.manufacturerId = manufacturerId;
    }
}

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
public class ProductParameterCriteria extends GenericCriteria {
    private Long productId;
    private Long parameterId;
    private String value;
    @Builder(builderMethodName = "childBuilder")
    public ProductParameterCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long productId, Long parameterId, String value) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.productId = productId;
        this.parameterId = parameterId;
        this.value = value;
    }
}

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
public class ManufacturerPaymentCriteria extends GenericCriteria {
    private Long manufacturerId;
    private Long orderWagonId;
    @Builder(builderMethodName = "childBuilder")
    public ManufacturerPaymentCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long manufacturerId, Long orderWagonId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.manufacturerId = manufacturerId;
        this.orderWagonId = orderWagonId;
    }
}

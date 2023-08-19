package dev.jlkeesh.papertrade.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:46
 */

@Getter
@Setter
@ParameterObject
public class OrderCriteria extends GenericCriteria{

    private String name;
    private Long manufacturerId;
    private Long consigneeId;
    private Long orderStatusId;

    @Builder(builderMethodName = "childBuilder")
    public OrderCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String name, Long manufacturerId, Long consigneeId, Long orderStatusId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.name = name;
        this.manufacturerId = manufacturerId;
        this.consigneeId = consigneeId;
        this.orderStatusId = orderStatusId;
    }
}

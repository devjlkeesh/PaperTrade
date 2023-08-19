package dev.jlkeesh.papertrade.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:17
 */

@Getter
@Setter
@ParameterObject
public class OrderWagonCriteria extends GenericCriteria {
    private Long orderProductId;
    private String wagonNum;
    private Long weight;
    private Integer quantity;

    @Builder(builderMethodName = "childBuilder")
    public OrderWagonCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long orderProductId, String wagonNum, Long weight, Integer quantity) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.orderProductId = orderProductId;
        this.wagonNum = wagonNum;
        this.weight = weight;
        this.quantity = quantity;
    }
}

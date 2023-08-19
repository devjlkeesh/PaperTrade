package dev.jlkeesh.papertrade.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 18:43
 */

@Getter
@Setter
@ParameterObject
public class OrderProductCriteria extends GenericCriteria {

    private Long orderId;
    private Long productId;
    private Long weight;
    private Integer quantity;
    private BigDecimal priceMan;
    private BigDecimal pricePrime;

    @Builder(builderMethodName = "childBuilder")
    public OrderProductCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long orderId, Long productId, Long weight, Integer quantity, BigDecimal priceMan, BigDecimal pricePrime) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.orderId = orderId;
        this.productId = productId;
        this.weight = weight;
        this.quantity = quantity;
        this.priceMan = priceMan;
        this.pricePrime = pricePrime;
    }
}

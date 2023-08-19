package dev.jlkeesh.papertrade.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:45
 */

@Getter
@Setter
@ParameterObject
public class TreasuryCriteria extends GenericCriteria {

    private Long treasureSourceId;
    private Long inCustomerPaymentId;
    private Long outExpenseId;

    @Builder(builderMethodName = "childBuilder")
    public TreasuryCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long treasureSourceId, Long inCustomerPaymentId, Long outExpenseId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.treasureSourceId = treasureSourceId;
        this.inCustomerPaymentId = inCustomerPaymentId;
        this.outExpenseId = outExpenseId;
    }
}

package dev.jlkeesh.papertrade.criteria;

import dev.jlkeesh.papertrade.enums.PaymentType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:07
 */

@Getter
@Setter
@ParameterObject
public class CustomerPaymentCriteria extends GenericCriteria {
    private Long customerId;
    private Long customerCompanyId;
    private Long tradeId;
    private Long consigneeId;
    private PaymentType paymentType;
    private Long otherCurrencyId;

    @Builder(builderMethodName = "childBuilder")
    public CustomerPaymentCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long customerId, Long customerCompanyId, Long tradeId, Long consigneeId, PaymentType paymentType, Long otherCurrencyId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.customerId = customerId;
        this.customerCompanyId = customerCompanyId;
        this.tradeId = tradeId;
        this.consigneeId = consigneeId;
        this.paymentType = paymentType;
        this.otherCurrencyId = otherCurrencyId;
    }
}

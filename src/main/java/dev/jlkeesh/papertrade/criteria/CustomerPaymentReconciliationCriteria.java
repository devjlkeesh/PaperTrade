package dev.jlkeesh.papertrade.criteria;

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
public class CustomerPaymentReconciliationCriteria extends GenericCriteria {
    private Long customerId;

    @Builder(builderMethodName = "childBuilder")
    public CustomerPaymentReconciliationCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long customerId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.customerId = customerId;
    }
}

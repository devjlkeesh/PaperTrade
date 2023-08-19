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
public class TradeProductCriteria extends GenericCriteria {
    private String barCode;

    @Builder(builderMethodName = "childBuilder")
    public TradeProductCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String barCode) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.barCode = barCode;
    }
}

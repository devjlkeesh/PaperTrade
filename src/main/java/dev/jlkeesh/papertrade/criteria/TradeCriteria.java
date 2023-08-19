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
public class TradeCriteria extends GenericCriteria {
    private Long customerId;
    private Long tradeStatusId;

    @Builder(builderMethodName = "childBuilder")

    public TradeCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long customerId, Long tradeStatusId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.customerId = customerId;
        this.tradeStatusId = tradeStatusId;
    }
}

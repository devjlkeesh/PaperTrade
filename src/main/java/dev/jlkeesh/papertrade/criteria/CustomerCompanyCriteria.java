package dev.jlkeesh.papertrade.criteria;

import dev.jlkeesh.papertrade.enums.State;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 13:10
 */

@Getter
@Setter
public class CustomerCompanyCriteria extends GenericCriteria {
    private String name;
    private State state;
    private Long customerId;

    @Builder(builderMethodName = "childBuilder")
    public CustomerCompanyCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String name, State state, Long customerId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.name = name;
        this.state = state;
        this.customerId = customerId;
    }
}

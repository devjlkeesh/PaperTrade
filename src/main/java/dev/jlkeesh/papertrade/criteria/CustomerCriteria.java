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
public class CustomerCriteria extends GenericCriteria {
    private String name;
    private String phone;
    private State state;
    private Long regionId;

    @Builder(builderMethodName = "childBuilder")
    public CustomerCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String name, String phone, State state, Long regionId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.name = name;
        this.phone = phone;
        this.state = state;
        this.regionId = regionId;
    }
}

package dev.jlkeesh.papertrade.criteria;

import dev.jlkeesh.papertrade.enums.State;
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
public class ConsigneeCriteria extends GenericCriteria {
    private String name;
    private State state;

    @Builder(builderMethodName = "childBuilder")
    public ConsigneeCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String name, State state) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.name = name;
        this.state = state;
    }
}

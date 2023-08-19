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
public class ParameterCriteria extends GenericCriteria {
    private String name;

    @Builder(builderMethodName = "childBuilder")
    public ParameterCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String name) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.name = name;
    }
}

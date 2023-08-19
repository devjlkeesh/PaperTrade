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
public class ExpenseCategoryCriteria extends GenericCriteria {
    private String name;
    private Long parentId;

    @Builder(builderMethodName = "childBuilder")
    public ExpenseCategoryCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String name, Long parentId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.name = name;
        this.parentId = parentId;
    }
}

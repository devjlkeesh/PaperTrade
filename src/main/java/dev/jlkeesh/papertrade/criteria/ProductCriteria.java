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
public class ProductCriteria extends GenericCriteria {
    private String name;
    private Long categoryId;
    @Builder(builderMethodName = "childBuilder")
    public ProductCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String name, Long categoryId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.name = name;
        this.categoryId = categoryId;
    }
}

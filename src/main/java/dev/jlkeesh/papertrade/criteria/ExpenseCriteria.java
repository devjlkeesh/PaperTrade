package dev.jlkeesh.papertrade.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:53
 */

@Getter
@Setter
@ParameterObject
public class ExpenseCriteria extends GenericCriteria {
    private Long expenseCategoryId;
    private Long orderWagonId;

    @Builder(builderMethodName = "childBuilder")
    public ExpenseCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, Long expenseCategoryId, Long orderWagonId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.expenseCategoryId = expenseCategoryId;
        this.orderWagonId = orderWagonId;
    }
}

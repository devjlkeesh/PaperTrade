package dev.jlkeesh.papertrade.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:04
 */
@Getter
@Setter
@ParameterObject
public class AuthRoleCriteria extends GenericCriteria {
    private String code;
    private List<Long> ids;

    @Builder(builderMethodName = "childBuilder")
    public AuthRoleCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String code, List<Long> ids) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.code = code;
        this.ids = ids;
    }
}

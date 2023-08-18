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
public class AuthUserCriteria extends GenericCriteria {
    private String username;
    private String phone;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, String username, String phone) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.username = username;
        this.phone = phone;
    }
}

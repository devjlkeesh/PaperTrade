package dev.jlkeesh.papertrade.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author : Elmurodov Javohir
 * @since : 01/06/23 / 15:38
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GenericCriteria {
    private Number selfId;
    private Integer page;
    private Integer size;
    protected String sortBy;
    protected String sortDirection;
    private String allSearch;

    public String getSortDirection() {
        return sortDirection == null || sortDirection.equals("") ? "asc" : sortDirection;
    }
}

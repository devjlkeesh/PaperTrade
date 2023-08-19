package dev.jlkeesh.papertrade.criteria;

import dev.jlkeesh.papertrade.enums.State;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

import java.time.LocalDateTime;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:04
 */
@Getter
@Setter
@ParameterObject
public class TreasureReconciliationCriteria extends GenericCriteria {
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Long currencyId;
    private Long treasureSourceId;

    @Builder(builderMethodName = "childBuilder")
    public TreasureReconciliationCriteria(Number selfId, Integer page, Integer size, String sortBy, String sortDirection, String allSearch, LocalDateTime beginDate, LocalDateTime endDate, Long currencyId, Long treasureSourceId) {
        super(selfId, page, size, sortBy, sortDirection, allSearch);
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.currencyId = currencyId;
        this.treasureSourceId = treasureSourceId;
    }
}

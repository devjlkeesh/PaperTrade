package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.TreasureReconciliation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreasureReconciliationUpdateDto implements Dto {
    @NotNull
    private Long id;
    private Double inSum;
    private Double remSum;
    private Double outSum;
    private String note;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Long treasureSourceId;
    private Long currencyId;
}
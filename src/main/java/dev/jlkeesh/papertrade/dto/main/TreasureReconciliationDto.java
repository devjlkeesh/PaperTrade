package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.TreasureReconciliation;
import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link TreasureReconciliation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreasureReconciliationDto implements Dto {
    private Long id;
    private Double inSum;
    private Double remSum;
    private Double outSum;
    private CurrencyDto currency;
    private TreasureSourceDto treasureSource;
    private String note;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;

    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
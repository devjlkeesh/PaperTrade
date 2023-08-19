package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.InventoryProductsReconciliation;
import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link InventoryProductsReconciliation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryProductsReconciliationUpdateDto implements Dto {
    @NotNull
    private Long id;
    private Long inWeight;
    private Double inSum;
    private Long remWeight;
    private Double remSum;
    private Long sellWeight;
    private Double sellSum;
    private Long defectWeight;
    private Double defectSum;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
}
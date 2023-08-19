package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.InventoryProductsReconciliation}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryProductsReconciliationCreateDto implements Dto {
    @NotNull
    private Long inWeight;
    @NotNull
    private Double inSum;
    @NotNull
    private Long remWeight;
    @NotNull
    private Double remSum;
    @NotNull
    private Long sellWeight;
    @NotNull
    private Double sellSum;
    @NotNull
    private Long defectWeight;
    @NotNull
    private Double defectSum;
    @NotNull
    private LocalDateTime beginDate;
    @NotNull
    private LocalDateTime endDate;
    @NotNull
    private Long inventoryId;
    @NotNull
    private Long productId;
    @NotNull
    private Long manufacturerId;
}
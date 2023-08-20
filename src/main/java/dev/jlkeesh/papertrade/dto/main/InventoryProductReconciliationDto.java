package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
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
public class InventoryProductReconciliationDto implements Dto {
    private Long id;
    private InventoryDto inventory;
    private ProductDto product;
    private ManufacturerDto manufacturer;
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
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
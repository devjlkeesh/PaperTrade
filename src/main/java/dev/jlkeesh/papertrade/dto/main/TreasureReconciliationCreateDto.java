package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
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
public class TreasureReconciliationCreateDto implements Dto {
    @NotNull
    private Double inSum;
    @NotNull
    private Double remSum;
    @NotNull
    private Double outSum;
    @NotBlank
    private String note;
    @NotNull
    private LocalDateTime beginDate;
    @NotNull
    private LocalDateTime endDate;
    @NotNull
    private Long treasureSourceId;
    @NotNull
    private Long currencyId;
}
package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.Trade}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeUpdateDto implements Dto {
    @NotNull
    private Long id;
    private String note;
}
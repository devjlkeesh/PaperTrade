package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.TradeProduct}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeProductUpdateDto implements Dto {
    @NotNull
    private Long id;
    private String barCode;
    private Long wight;
    private Double pricePrime;
    private Double priceSell;
    private Double otherSellPrice;
}
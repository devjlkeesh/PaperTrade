package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.domains.main.Product;
import dev.jlkeesh.papertrade.domains.main.Trade;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
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
public class TradeProductCreateDto implements Dto {
    @NotBlank
    private String barCode;
    @NotNull
    private Long wight;
    @NotNull
    private Double pricePrime;
    @NotNull
    private Double priceSell;
    @NotNull
    private Double otherSellPrice;
    @NotNull
    private Long tradeId;
    @NotNull
    private Long productId;
    @NotNull
    private Long manufacturerId;
    @NotNull
    private Long currencyId;
}
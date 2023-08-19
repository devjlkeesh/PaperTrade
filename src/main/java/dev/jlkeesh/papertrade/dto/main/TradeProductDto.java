package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.TradeProduct}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeProductDto implements Dto {
    private Long id;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private TradeDto trade;
    private ProductDto product;
    private ManufacturerDto manufacturer;
    private CurrencyDto currency;
    private String barCode;
    private Long wight;
    private Double pricePrime;
    private Double priceSell;
    private Double otherSellPrice;
}
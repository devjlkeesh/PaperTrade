package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.ProductPrice;
import dev.jlkeesh.papertrade.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link ProductPrice}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceCreateDto implements Dto {
    private Long productId;
    private Long manufacturerId;
    private Double priceMan;
    private Double pricePrime;
    private Double priceSell;
    private Double priceManNds;
}
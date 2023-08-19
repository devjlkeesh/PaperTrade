package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.ProductPrice}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceDto implements Dto {
    private Long id;
    private ManufacturerDto manufacturer;
    private ProductDto product;
    private Double priceMan;
    private Double pricePrime;
    private Double priceSell;
    private Double priceManNds;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
}
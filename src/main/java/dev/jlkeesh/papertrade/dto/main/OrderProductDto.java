package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 18:45
 */

public record OrderProductDto(Long id,
                              Long orderId,
                              Long productId,
                              Long weight,
                              Integer quantity,
                              BigDecimal priceMan,
                              BigDecimal pricePrime) implements Dto {
}

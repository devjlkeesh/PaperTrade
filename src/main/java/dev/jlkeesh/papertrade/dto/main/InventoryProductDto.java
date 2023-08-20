package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 10:57
 */
public record InventoryProductDto(Long id,
                                  Long inventoryId,
                                  Long productId,
                                  Long manufacturerId,
                                  Long tradeProductId) implements Dto {
}

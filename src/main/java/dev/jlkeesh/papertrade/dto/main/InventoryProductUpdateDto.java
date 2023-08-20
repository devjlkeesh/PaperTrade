package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import lombok.NonNull;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 10:58
 */
public record InventoryProductUpdateDto(@NonNull Long id,
                                        Long inventoryId,
                                        Long productId,
                                        Long manufacturerId,
                                        Long tradeProductId) implements Dto {
}

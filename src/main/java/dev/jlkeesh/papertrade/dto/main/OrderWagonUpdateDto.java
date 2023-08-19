package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:16
 */
public record OrderWagonUpdateDto(@NotNull Long id,
                                  Long orderProductId,
                                  String wagonNum,
                                  Long weight,
                                  Integer quantity) implements Dto {
}

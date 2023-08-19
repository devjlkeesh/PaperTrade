package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:15
 */
public record OrderWagonCreateDto(Long orderProductId,
                                  String wagonNum,
                                  Long weight,
                                  Integer quantity) implements Dto {
}

package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:13
 */
public record OrderWagonDto(Long id,
                            Long orderProductId,
                            String wagonNum,
                            Long weight,
                            Integer quantity) implements Dto {
}

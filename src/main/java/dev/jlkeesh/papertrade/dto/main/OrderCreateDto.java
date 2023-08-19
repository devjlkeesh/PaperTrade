package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:38
 */
public record OrderCreateDto(@NotBlank String name) implements Dto {
}

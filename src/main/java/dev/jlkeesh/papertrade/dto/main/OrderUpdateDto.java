package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:39
 */

public record OrderUpdateDto(@NotNull Long id, @NotBlank String name) implements Dto {
}

package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryUpdateDto(@NotNull Long id, @NotBlank String name) implements Dto {
}
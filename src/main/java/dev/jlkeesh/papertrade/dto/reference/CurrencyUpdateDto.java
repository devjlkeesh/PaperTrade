package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.reference.Currency}
 */
public record CurrencyUpdateDto(@NotNull Long id, @NotBlank String name, @NotBlank Double value) implements Dto {
}
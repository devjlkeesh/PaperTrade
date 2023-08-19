package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.reference.Currency}
 */
public record CurrencyCreateDto(@NotEmpty String name, @Positive Double value) implements Dto {
}
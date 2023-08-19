package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.domains.reference.Country;
import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link Country}
 */
public record CountryUpdateDto(@NotNull Long id, @NotBlank String name) implements Dto {
}
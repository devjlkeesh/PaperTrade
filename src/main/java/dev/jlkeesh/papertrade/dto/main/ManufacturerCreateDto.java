package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.main.Manufacturer}
 */
public record ManufacturerCreateDto(@NotBlank String name, @NotNull Long countryId) implements Dto {
}
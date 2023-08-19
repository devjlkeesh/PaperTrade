package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.State;
import jakarta.validation.constraints.NotNull;

/**
 * DTO for {@link Manufacturer}
 */
public record ManufacturerUpdateDto(@NotNull Long id, String name, State state, Long countryId) implements Dto {
}
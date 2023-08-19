package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.reference.CountryDto;
import dev.jlkeesh.papertrade.enums.State;

import java.time.LocalDateTime;

/**
 * DTO for {@link Manufacturer}
 */
public record ManufacturerDto(Long id, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy,
                              String name, State state, CountryDto country) implements Dto {
}
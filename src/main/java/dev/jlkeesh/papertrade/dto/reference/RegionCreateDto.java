package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotEmpty;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.reference.Region}
 */
public record RegionCreateDto(@NotEmpty String name) implements Dto {
}
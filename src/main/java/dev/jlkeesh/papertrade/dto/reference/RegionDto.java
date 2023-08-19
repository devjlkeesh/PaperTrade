package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.dto.Dto;

import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.reference.Country}
 */

public record RegionDto(Long id,
                        String name,
                        LocalDateTime createdAt,
                        Long createdBy,
                        LocalDateTime updatedAt,
                        Long updatedBy) implements Dto {
}
package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.dto.Dto;

import java.time.LocalDateTime;

/**
 * DTO for {@link dev.jlkeesh.papertrade.domains.reference.Currency}
 */

public record CurrencyDto(Long id,
                          String name,
                          Double value,
                          LocalDateTime createdAt,
                          Long createdBy,
                          LocalDateTime updatedAt,
                          Long updatedBy) implements Dto {
}
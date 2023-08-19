package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.dto.Dto;

import java.time.LocalDateTime;

public record CategoryDto(Long id,
                          String name,
                          LocalDateTime createdAt,
                          Long createdBy,
                          LocalDateTime updatedAt,
                          Long updatedBy) implements Dto {
}
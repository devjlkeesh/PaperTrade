package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.reference.CategoryDto;

import java.time.LocalDateTime;

public record ProductDto(Long id,
                         String name,
                         CategoryDto category,
                         LocalDateTime createdAt,
                         Long createdBy,
                         LocalDateTime updatedAt,
                         Long updatedBy) implements Dto {
}
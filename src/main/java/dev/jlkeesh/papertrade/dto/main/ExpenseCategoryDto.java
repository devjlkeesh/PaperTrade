package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

import java.time.LocalDateTime;
import java.util.List;

public record ExpenseCategoryDto(Long id,
                                 String name,
                                 List<ExpenseCategoryDto> children,
                                 LocalDateTime createdAt,
                                 Long createdBy,
                                 LocalDateTime updatedAt,
                                 Long updatedBy) implements Dto {
}
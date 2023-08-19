package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotEmpty;

public record ExpenseCategoryCreateDto(@NotEmpty String name, Long parentId) implements Dto {
}
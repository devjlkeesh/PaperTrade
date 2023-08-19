package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateDto(@NotNull Long id, String name, Long categoryId) implements Dto {}
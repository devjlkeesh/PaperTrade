package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotEmpty;

public record TreasureSourceCreateDto(@NotEmpty String name) implements Dto {
}
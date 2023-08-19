package dev.jlkeesh.papertrade.dto.reference;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotEmpty;

public record ParameterCreateDto(@NotEmpty String name) implements Dto {
}
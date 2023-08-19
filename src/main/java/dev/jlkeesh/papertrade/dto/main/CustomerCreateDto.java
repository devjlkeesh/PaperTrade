package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public record CustomerCreateDto(@NotBlank String name, @Pattern(regexp = "\\\\d{12}") String phone, @NotNull Long regionId) implements Dto {
}
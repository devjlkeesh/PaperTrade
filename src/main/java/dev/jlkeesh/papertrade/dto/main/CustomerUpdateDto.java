package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomerUpdateDto(@NotNull Long id, String name, @Pattern(regexp = "\\\\d{12}") String phone,
                                Long regionId) implements Dto {
}
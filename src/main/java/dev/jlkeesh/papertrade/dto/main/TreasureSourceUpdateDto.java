package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.State;
import jakarta.validation.constraints.NotNull;

public record TreasureSourceUpdateDto(@NotNull Long id, String name, State state) implements Dto {
}
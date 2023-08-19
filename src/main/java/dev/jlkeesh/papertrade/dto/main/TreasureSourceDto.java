package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.State;

import java.time.LocalDateTime;

public record TreasureSourceDto(Long id,
                                String name,
                                State state,
                                LocalDateTime createdAt,
                                Long createdBy,
                                LocalDateTime updatedAt,
                                Long updatedBy) implements Dto {
}
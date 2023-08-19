package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

import java.time.LocalDateTime;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:37
 */

public record OrderDto(Long id,
                       String name,
                       LocalDateTime createdAt,
                       Long createdBy,
                       LocalDateTime updatedAt,
                       Long updatedBy) implements Dto {
}

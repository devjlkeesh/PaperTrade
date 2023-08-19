package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:52
 */

public record ExpenseUpdateDto(@NotNull Long id,
                               Long expenseCategoryId,
                               Long orderWagonId,
                               BigDecimal summa,
                               Long otherCurrencyId,
                               BigDecimal otherSumma,
                               String note) implements Dto {
}

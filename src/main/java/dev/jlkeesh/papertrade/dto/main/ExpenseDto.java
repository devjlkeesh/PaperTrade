package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:50
 */

public record ExpenseDto(Long id,
                         Long expenseCategoryId,
                         Long orderWagonId,
                         BigDecimal summa,
                         Long otherCurrencyId,
                         BigDecimal otherSumma,
                         String note) implements Dto {

}

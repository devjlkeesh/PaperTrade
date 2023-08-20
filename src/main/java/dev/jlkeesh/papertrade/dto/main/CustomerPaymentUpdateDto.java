package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.PaymentType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:02
 */

public record CustomerPaymentUpdateDto(@NotNull Long id,
                                       Long customerId,
                                       Long customerCompanyId,
                                       Long tradeId,
                                       Long consigneeId,
                                       PaymentType paymentType,
                                       BigDecimal credit,
                                       BigDecimal debit,
                                       Long otherCurrencyId,
                                       BigDecimal otherCredit,
                                       BigDecimal otherDebit,
                                       String note) implements Dto {
}

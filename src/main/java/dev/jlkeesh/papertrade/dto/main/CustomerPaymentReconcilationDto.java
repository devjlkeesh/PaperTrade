package dev.jlkeesh.papertrade.dto.main;

import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.enums.PaymentType;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/23 - 09:29
 */

public record CustomerPaymentReconcilationDto(Long id,
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
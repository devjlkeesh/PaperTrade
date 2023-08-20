package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/23 - 09:24
 */

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER_PAYMENT_RECONCILIATIONS")
public class CustomerPaymentReconciliation extends Auditable {

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "CUSTOMER_ID")
    private Customer customer;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal deposit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal credit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal debit;

    @ManyToOne(targetEntity = Currency.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "OTHER_CURRENCY_ID")
    private Currency otherCurrency;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal otherDeposit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal otherCredit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal otherDebit;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private LocalDate beginDate;

    @Column(nullable = false)
    private LocalDate endDate;
}

package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:38
 */

@Getter
@Setter
@Entity
@Table(name = "TREASURIES")
public class Treasury extends Auditable {

    @ManyToOne(targetEntity = TreasureSource.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "TREASURE_SOURCE_ID")
    private TreasureSource treasureSource;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal inSum;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal remSum;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal outSum;

    @ManyToOne(targetEntity = Currency.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "CURRENCY_ID")
    private Currency currency;

    @OneToOne(targetEntity = CustomerPayment.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "IN_CUSTOMER_PAYMENT_ID")
    private CustomerPayment inCustomerPayment;

    @OneToOne(targetEntity = Expense.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "OUT_EXPENSE_ID")
    private Expense outExpense;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private LocalDateTime registerDate;
}

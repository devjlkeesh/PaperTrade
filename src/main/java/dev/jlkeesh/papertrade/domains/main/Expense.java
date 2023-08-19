package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:38
 */

@Getter
@Setter
@Entity
@Table(name = "EXPENSES")
public class Expense extends Auditable {

    @ManyToOne(targetEntity = OrderProduct.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "EXPENSE_CATEGORY_ID", nullable = false)
    private ExpenseCategory expenseCategory;

    @OneToOne(targetEntity = OrderProduct.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_WAGON_ID", nullable = false)
    private OrderWagon orderWagon;

    private BigDecimal summa;

    @ManyToOne(targetEntity = Currency.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "OTHER_CURRENCY_ID")
    private Currency otherCurrency;

    private BigDecimal otherSumma;

    private String note;
}

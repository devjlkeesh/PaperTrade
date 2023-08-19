package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.enums.PaymentType;
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
@Table(name = "CUSTOMER_PAYMENT")
public class CustomerPayment extends Auditable {

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(targetEntity = CustomerCompany.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "CUSTOMER_COMPANY_ID")
    private CustomerCompany customerCompany;

    @ManyToOne(targetEntity = Trade.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "TRADE_ID")
    private Trade trade;

    @ManyToOne(targetEntity = Consignee.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "CONSIGNEE_ID")
    private Consignee consignee;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal credit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal debit;

    @ManyToOne(targetEntity = Currency.class, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "OTHER_CURRENCY_ID")
    private Currency otherCurrency;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal otherCredit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal otherDebit;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private LocalDateTime registerDate;
}

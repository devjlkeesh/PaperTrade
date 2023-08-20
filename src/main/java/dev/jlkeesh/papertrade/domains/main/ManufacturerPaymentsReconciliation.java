package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:49
 */

@Entity
@Getter
@Setter
public class ManufacturerPaymentsReconciliation extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne
    @JoinColumn(nullable = false, name = "consignee_id")
    private Consignee consignee;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @OneToOne
    @JoinColumn(nullable = false, name = "other_currency_id")
    private Currency currency;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double deposit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double credit;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double debit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double otherDeposit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double otherCredit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double otherDebit;

    @Column(nullable = false)
    private LocalDateTime beginDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

}

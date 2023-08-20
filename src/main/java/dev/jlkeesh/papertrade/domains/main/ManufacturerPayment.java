package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Country;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.enums.PaymentType;
import dev.jlkeesh.papertrade.enums.State;
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
public class ManufacturerPayment extends Auditable {

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false, name = "country_id")
    private Country country;

    @OneToOne
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne
    @JoinColumn(nullable = false, name = "order_wagon_id")
    private OrderWagon orderWagon;

    @OneToOne
    @JoinColumn(nullable = false, name = "consignee_id")
    private Consignee consignee;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double credit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double debit;

    @Column(nullable = false)
    private String note;

    @OneToOne
    @JoinColumn(nullable = false, name = "other_currency_id")
    private Currency currency;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double otherCredit;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double   otherDebit;

    @Column(nullable = false)
    private LocalDateTime registerDate;

}

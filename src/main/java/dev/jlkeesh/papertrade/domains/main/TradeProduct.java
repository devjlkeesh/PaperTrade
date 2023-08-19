package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 21:59
 */

@Getter
@Setter
@Entity
public class TradeProduct extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "trade_id")
    private Trade trade;

    @OneToOne
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne
    @JoinColumn(nullable = false, name = "currency_id")
    private Currency currency;

    @Column(nullable = false)
    private String barCode;

    @Column(nullable = false)
    private Long wight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double pricePrime;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double priceSell;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double otherSellPrice;


}

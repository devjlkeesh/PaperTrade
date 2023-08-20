package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/23 - 10:56
 */

@Getter
@Setter
@Entity
public class InventoryProduct extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "INVENTORY_ID")
    private Inventory inventory;

    @OneToOne
    @JoinColumn(nullable = false, name = "PRODUCT_ID")
    private Product product;

    @OneToOne
    @JoinColumn(nullable = false, name = "MANUFACTURER_ID")
    private Manufacturer manufacturer;

    @OneToOne
    @JoinColumn(nullable = false, name = "ORDER_PRODUCT_ID")
    private OrderProduct orderProduct;

    @OneToOne
    @JoinColumn(nullable = false, name = "SELL_TRADE_PRODUCT_ID")
    private TradeProduct tradeProduct;

    @Column(nullable = false)
    private String barCode;

    @Column(nullable = false)
    private Long inWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal inPrice;

    @Column(nullable = false)
    private Long remWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal remPrice;

    @Column(nullable = false)
    private Long sellWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal sellPrice;

    @Column(nullable = false)
    private Long defectWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private BigDecimal defectPrice;

    @Column(nullable = false)
    private LocalDate registerDate;
}

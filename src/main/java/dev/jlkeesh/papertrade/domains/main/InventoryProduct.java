package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 21:59
 */

@Getter
@Setter
@Entity
public class InventoryProduct extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "inventory_id")
    private Inventory inventory;

    @OneToOne
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne
    @JoinColumn(nullable = false, name = "order_product_id")
    private OrderProduct orderProduct;

    @OneToOne
    @JoinColumn(nullable = false, name = "sell_trade_product_id")
    private TradeProduct tradeProduct;

    @Column(nullable = false)
    private String barCode;

    @Column(nullable = false)
    private Long inWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double inPrice;

    @Column(nullable = false)
    private Long remWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double remPrice;

    @Column(nullable = false)
    private Long sellWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double sellPrice;

    @Column(nullable = false)
    private Long defectWeight;

    @Column(nullable = false, columnDefinition = "numeric(20, 2)")
    private Double defectPrice;

    @Column(nullable = false)
    private LocalDateTime registerDate;

}

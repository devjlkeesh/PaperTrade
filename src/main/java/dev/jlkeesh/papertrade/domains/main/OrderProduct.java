package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 17:35
 */

@Getter
@Setter
@Entity
@Table(name = "ORDER_PRODUCTS")
public class OrderProduct extends Auditable {

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    private Long weight;

    private Integer quantity;

    private BigDecimal priceMan;

    private BigDecimal price_prime;

    @ManyToOne(targetEntity = Currency.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "OTHER_CURRENCY_ID")
    private Currency otherCurrency;

    private BigDecimal otherPrice;
}

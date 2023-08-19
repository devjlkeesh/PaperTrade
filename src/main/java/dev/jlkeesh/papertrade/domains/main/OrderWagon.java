package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 20:55
 */

@Getter
@Setter
@Entity
@Table(name = "ORDER_WAGONS")
public class OrderWagon extends Auditable {

    @OneToOne(targetEntity = OrderProduct.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_PRODUCT_ID", nullable = false)
    private OrderProduct orderProduct;

    private String wagonNum;

    private Long weight;

    private Integer quantity;
}

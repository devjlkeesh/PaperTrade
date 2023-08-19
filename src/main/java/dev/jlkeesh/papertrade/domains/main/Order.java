package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:40
 */

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order extends Auditable {

    @OneToOne
    @JoinColumn(nullable = false, name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne
    @JoinColumn(nullable = false, name = "consignee_id")
    private Consignee consignee;

    @OneToOne
    @JoinColumn(nullable = false, name = "order_status_id")
    private OrderStatus orderStatus;

    @Column(nullable = false)
    private String name;
}

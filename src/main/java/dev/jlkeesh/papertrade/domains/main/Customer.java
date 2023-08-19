package dev.jlkeesh.papertrade.domains.main;

import dev.jlkeesh.papertrade.domains.Auditable;
import dev.jlkeesh.papertrade.domains.reference.Region;
import dev.jlkeesh.papertrade.enums.State;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 11:49
 */

@Entity
@Getter
@Setter
public class Customer extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    @OneToOne
    @JoinColumn(nullable = false, name = "region_id")
    private Region region;

}

package dev.jlkeesh.papertrade.domains.main.auth;

import dev.jlkeesh.papertrade.domains.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 08:38
 */

@Entity
@Getter
@Setter
public class AuthUser extends Auditable {

    @Column(nullable = false, name = "fullname")
    private String fullName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<AuthRole> roles;

    private LocalDateTime lastLoginAt;

    private LocalDateTime lastActionedAt;

    public void addRoles(@NonNull List<AuthRole> authRoles) {
        if (this.roles == null)
            this.roles = authRoles;
        this.roles.addAll(authRoles);
    }
}

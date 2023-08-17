package dev.jlkeesh.papertrade.repository;

import dev.jlkeesh.papertrade.domains.auth.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRoleRepository extends JpaRepository<AuthRole, Long> {
}
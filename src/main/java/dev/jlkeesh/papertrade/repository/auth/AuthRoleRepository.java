package dev.jlkeesh.papertrade.repository.auth;

import dev.jlkeesh.papertrade.criteria.AuthRoleCriteria;
import dev.jlkeesh.papertrade.criteria.AuthUserCriteria;
import dev.jlkeesh.papertrade.domains.auth.AuthRole;
import dev.jlkeesh.papertrade.domains.auth.AuthUser;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRoleRepository extends GenericCrudRepository<AuthRole, Long, AuthRoleCriteria> {
}
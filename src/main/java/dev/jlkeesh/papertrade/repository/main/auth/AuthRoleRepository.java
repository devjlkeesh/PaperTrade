package dev.jlkeesh.papertrade.repository.main.auth;

import dev.jlkeesh.papertrade.criteria.AuthRoleCriteria;
import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

public interface AuthRoleRepository extends GenericCrudRepository<AuthRole, Long, AuthRoleCriteria> {
}
package dev.jlkeesh.papertrade.repository.main.auth;

import dev.jlkeesh.papertrade.criteria.AuthUserCriteria;
import dev.jlkeesh.papertrade.domains.main.auth.AuthUser;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

public interface AuthUserRepository extends GenericCrudRepository<AuthUser, Long, AuthUserCriteria> {
}
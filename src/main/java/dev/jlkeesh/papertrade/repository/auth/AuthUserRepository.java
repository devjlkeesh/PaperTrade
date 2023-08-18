package dev.jlkeesh.papertrade.repository.auth;

import dev.jlkeesh.papertrade.criteria.AuthUserCriteria;
import dev.jlkeesh.papertrade.domains.auth.AuthUser;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;
import org.springframework.stereotype.Repository;

public interface AuthUserRepository extends GenericCrudRepository<AuthUser, Long, AuthUserCriteria> {
}
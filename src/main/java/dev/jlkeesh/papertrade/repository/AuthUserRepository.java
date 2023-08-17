package dev.jlkeesh.papertrade.repository;

import dev.jlkeesh.papertrade.domains.auth.AuthUser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    @Query("select a from AuthUser a where upper(a.username) = upper(?1) ")
    Optional<AuthUser> findUser(String o);
}
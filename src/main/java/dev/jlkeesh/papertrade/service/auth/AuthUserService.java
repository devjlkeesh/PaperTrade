package dev.jlkeesh.papertrade.service.auth;

import dev.jlkeesh.papertrade.configs.security.UserDetails;
import dev.jlkeesh.papertrade.criteria.AuthUserCriteria;
import dev.jlkeesh.papertrade.domains.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.auth.*;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.GenericCrudService;
import org.springframework.http.ResponseEntity;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 21:44
 */
public interface AuthUserService extends GenericCrudService<AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto, AuthUserCriteria, Long> {
    ResponseEntity<Data<GetTokenResponse>> getToken(GetTokenRequest request);

    AuthUser loadUserByUsername(String username);

    AuthUser loadUserById(Long id);

    ResponseEntity<Data<UserDetails>> getMe();

    ResponseEntity<Data<Boolean>> attachRole(AuthUserAttachRoleDto dto);
}

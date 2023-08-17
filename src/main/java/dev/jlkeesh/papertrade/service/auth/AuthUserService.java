package dev.jlkeesh.papertrade.service.auth;

import dev.jlkeesh.papertrade.configs.security.UserDetails;
import dev.jlkeesh.papertrade.domains.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.auth.GetTokenRequest;
import dev.jlkeesh.papertrade.dto.auth.GetTokenResponse;
import dev.jlkeesh.papertrade.service.GenericService;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 21:44
 */
public interface AuthUserService extends GenericService {
    GetTokenResponse getToken(GetTokenRequest request);
    AuthUser loadUserByUsername(String username);
    AuthUser loadUserById(Long id);

    UserDetails getMe();
}

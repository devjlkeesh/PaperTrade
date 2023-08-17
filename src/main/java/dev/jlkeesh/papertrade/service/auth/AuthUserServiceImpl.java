package dev.jlkeesh.papertrade.service.auth;

import dev.jlkeesh.papertrade.configs.security.CurrentUser;
import dev.jlkeesh.papertrade.configs.security.UserDetails;
import dev.jlkeesh.papertrade.configs.security.jwt.JWTUtils;
import dev.jlkeesh.papertrade.domains.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.auth.GetTokenRequest;
import dev.jlkeesh.papertrade.dto.auth.GetTokenResponse;
import dev.jlkeesh.papertrade.dto.auth.TokenDto;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.Type;
import dev.jlkeesh.papertrade.exceptions.AuthorizedException;
import dev.jlkeesh.papertrade.repository.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 21:48
 */
@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService {
    private final JWTUtils jwtUtils;
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    @Override
    public GetTokenResponse getToken(GetTokenRequest request) {

        AuthUser authUser = loadUserByUsername(request.username());

        if (!passwordEncoder.matches(request.password(), authUser.getPassword()))
            throw new AuthorizedException(ErrorCode.AUTH_BAD_CREDENTIALS);

        TokenDto access = jwtUtils.generateToken(authUser.getId(), Type.ACCESS);
        TokenDto refresh = jwtUtils.generateToken(authUser.getId(), Type.ACCESS);

        authUser.setLastLoginAt(LocalDateTime.now());
        authUser.setLastActionedAt(LocalDateTime.now());
        UserDetails userDetails = new UserDetails(authUser);
        var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        authUserRepository.save(authUser);

        return new GetTokenResponse(access, refresh);
    }

    @Override
    public UserDetails getMe() {
        return currentUser.getUser();
    }


    @Override
    public AuthUser loadUserByUsername(String username) {
        return authUserRepository.findUser(username)
                .orElseThrow(() -> new AuthorizedException(ErrorCode.AUTH_BAD_CREDENTIALS));
    }

    @Override
    @Cacheable(cacheNames = {"users"}, key = "#id")
    public AuthUser loadUserById(Long id) {
        return authUserRepository.findById(id)
                .orElseThrow(() -> new AuthorizedException(ErrorCode.AUTH_UNAUTHORIZED));
    }

}

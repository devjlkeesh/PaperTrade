package dev.jlkeesh.papertrade.service.auth;

import dev.jlkeesh.papertrade.configs.security.CurrentUser;
import dev.jlkeesh.papertrade.configs.security.UserDetails;
import dev.jlkeesh.papertrade.configs.security.jwt.JWTUtils;
import dev.jlkeesh.papertrade.criteria.AuthRoleCriteria;
import dev.jlkeesh.papertrade.criteria.AuthUserCriteria;
import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.domains.main.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.main.auth.*;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.Type;
import dev.jlkeesh.papertrade.exceptions.AuthorizedException;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.AuthUserMapper;
import dev.jlkeesh.papertrade.repository.main.auth.AuthRoleRepository;
import dev.jlkeesh.papertrade.repository.main.auth.AuthUserRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 21:48
 */
@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper> implements AuthUserService {
    private final JWTUtils jwtUtils;
    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final AuthRoleRepository authRoleRepository;

    protected AuthUserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper,
                                  JWTUtils jwtUtils,
                                  AuthUserRepository authUserRepository,
                                  PasswordEncoder passwordEncoder,
                                  CurrentUser currentUser, AuthRoleRepository authRoleRepository) {
        super(repository, mapper);
        this.jwtUtils = jwtUtils;
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.authRoleRepository = authRoleRepository;
    }

    @Override
    public ResponseEntity<Data<GetTokenResponse>> getToken(GetTokenRequest request) {

        AuthUser authUser = loadUserByUsername(request.username());

        if (!passwordEncoder.matches(request.password(), authUser.getPassword()))
            throw new AuthorizedException(ErrorCode.AUTH_BAD_CREDENTIALS);

        TokenDto access = jwtUtils.generateToken(authUser.getId(), Type.ACCESS);
        TokenDto refresh = jwtUtils.generateToken(authUser.getId(), Type.REFRESH);

        authUser.setLastLoginAt(LocalDateTime.now());
        authUser.setLastActionedAt(LocalDateTime.now());
        UserDetails userDetails = new UserDetails(authUser);
        var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        authUserRepository.save(authUser);
        return new ResponseEntity<>(new Data<>(new GetTokenResponse(access, refresh)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<UserDetails>> getMe() {
        return new ResponseEntity<>(new Data<>(currentUser.getUser()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> attachRole(AuthUserAttachRoleDto dto) {
        AuthUser authUser = repository.find(dto.userId()).orElseThrow(ResourceNotFoundException::new);
        List<AuthRole> authRoles = authRoleRepository.findAll(AuthRoleCriteria.childBuilder()
                .ids(dto.roles())
                .build());
        authUser.addRoles(authRoles);
        repository.save(authUser);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }


    @Override
    public AuthUser loadUserByUsername(String username) {
        return authUserRepository.find(AuthUserCriteria.childBuilder().username(username).build())
                .orElseThrow(() -> new AuthorizedException(ErrorCode.AUTH_BAD_CREDENTIALS));
    }

    @Override
    @Cacheable(cacheNames = {"users"}, key = "#id")
    public AuthUser loadUserById(Long id) {
        return authUserRepository.find(id)
                .orElseThrow(() -> new AuthorizedException(ErrorCode.AUTH_UNAUTHORIZED));
    }

    @Override
    public ResponseEntity<Data<List<AuthUserDto>>> getAll(@NonNull AuthUserCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<AuthUser> authUsers = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(authUsers), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<AuthUserDto>> get(@NonNull Long id) {
        AuthUser authUser = repository.find(id).orElseThrow(ResourceNotFoundException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(authUser)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull AuthUserCreateDto dto) {

        repository.find(AuthUserCriteria.childBuilder().username(dto.getUsername()).build())
                .ifPresent(authUser -> {
                    throw new BadRequestException(ErrorCode.USER_NAME_ALREADY_TAKEN);
                });

        repository.find(AuthUserCriteria.childBuilder().phone(dto.getPhone()).build())
                .ifPresent(authUser -> {
                    throw new BadRequestException(ErrorCode.PHONE_NUMBER_ALREADY_TAKEN);
                });

        AuthUser authUser = mapper.fromCreateDto(dto);
        authUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        repository.save(authUser);
        return new ResponseEntity<>(new Data<>(authUser.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull AuthUserUpdateDto dto) {
        AuthUser authUser = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, authUser));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

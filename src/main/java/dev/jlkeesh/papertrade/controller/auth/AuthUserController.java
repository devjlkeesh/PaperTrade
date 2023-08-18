package dev.jlkeesh.papertrade.controller.auth;

import dev.jlkeesh.papertrade.configs.security.UserDetails;
import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.AuthUserCriteria;
import dev.jlkeesh.papertrade.dto.auth.*;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.auth.AuthUserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 16/08/23 / 21:42
 */
@RestController
public class AuthUserController extends AbstractController<AuthUserService> {
    protected AuthUserController(AuthUserService service) {
        super(service);
    }

    @PostMapping(PATH + "/auth/get-token")
    public ResponseEntity<Data<GetTokenResponse>> getToken(@NonNull @Valid @RequestBody GetTokenRequest request) {
        return service.getToken(request);
    }

    @GetMapping(PATH + "/auth/get-me")
    public ResponseEntity<Data<UserDetails>> getMe() {
        return service.getMe();
    }


    @GetMapping(PATH + "/auth-user/{id}")
    public ResponseEntity<Data<AuthUserDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/auth-user")
    public ResponseEntity<Data<List<AuthUserDto>>> getAll(AuthUserCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/auth-user")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody AuthUserCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/auth-user/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/auth-user")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody AuthUserUpdateDto dto) {
        return service.update(dto);
    }
    @PostMapping(PATH + "/auth-user/attach-role")
    public ResponseEntity<Data<Boolean>> attachRole(@NonNull @Valid @RequestBody AuthUserAttachRoleDto dto) {
        return service.attachRole(dto);
    }

}

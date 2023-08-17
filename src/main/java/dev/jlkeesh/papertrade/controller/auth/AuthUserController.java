package dev.jlkeesh.papertrade.controller.auth;

import dev.jlkeesh.papertrade.configs.security.UserDetails;
import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.dto.auth.GetTokenRequest;
import dev.jlkeesh.papertrade.dto.auth.GetTokenResponse;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.auth.AuthUserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<>(new Data<>(service.getToken(request)), HttpStatus.OK);
    }

    @GetMapping(PATH + "/auth/get-me")
    public ResponseEntity<Data<UserDetails>> getMe() {
        return new ResponseEntity<>(new Data<>(service.getMe()), HttpStatus.OK);
    }

}

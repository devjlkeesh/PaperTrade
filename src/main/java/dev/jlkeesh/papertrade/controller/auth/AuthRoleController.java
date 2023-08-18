package dev.jlkeesh.papertrade.controller.auth;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.AuthRoleCriteria;
import dev.jlkeesh.papertrade.dto.auth.AuthRoleUpdateDto;
import dev.jlkeesh.papertrade.dto.auth.AuthRoleCreateDto;
import dev.jlkeesh.papertrade.dto.auth.AuthRoleDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.auth.AuthRoleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 19:57
 */

@RestController
public class AuthRoleController extends AbstractController<AuthRoleService> {
    protected AuthRoleController(AuthRoleService service) {
        super(service);
    }

    @GetMapping(PATH + "/auth-role/{id}")
    public ResponseEntity<Data<AuthRoleDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/auth-role")
    public ResponseEntity<Data<List<AuthRoleDto>>> getAll(AuthRoleCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/auth-role")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody AuthRoleCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/auth-role/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/auth-role")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody AuthRoleUpdateDto dto) {
        return service.update(dto);
    }
}

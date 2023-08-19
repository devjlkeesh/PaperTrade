package dev.jlkeesh.papertrade.service.auth;

import dev.jlkeesh.papertrade.criteria.AuthRoleCriteria;
import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleCreateDto;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleDto;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.AuthRoleMapper;
import dev.jlkeesh.papertrade.repository.main.auth.AuthRoleRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:54
 */
@Service
public class AuthRoleServiceImpl extends AbstractService<AuthRoleRepository, AuthRoleMapper> implements AuthRoleService {

    protected AuthRoleServiceImpl(AuthRoleRepository repository, AuthRoleMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<AuthRoleDto>>> getAll(@NonNull AuthRoleCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<AuthRole> authRoles = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(authRoles), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<AuthRoleDto>> get(@NonNull Long id) {
        AuthRole authRole = repository.find(id).orElseThrow(ResourceNotFoundException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(authRole)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull AuthRoleCreateDto dto) {
        AuthRoleCriteria criteria = AuthRoleCriteria.childBuilder().code(dto.getCode()).build();
        repository.find(criteria).ifPresent(authRole -> {
            throw new BadRequestException(ErrorCode.RESOURCE_EXISTS);
        });
        dto.upperCase();
        AuthRole authRole = mapper.fromCreateDto(dto);
        repository.save(authRole);
        return new ResponseEntity<>(new Data<>(authRole.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull AuthRoleUpdateDto dto) {
        AuthRole authRole = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, authRole));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

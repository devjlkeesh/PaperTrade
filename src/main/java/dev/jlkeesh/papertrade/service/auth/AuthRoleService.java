package dev.jlkeesh.papertrade.service.auth;

import dev.jlkeesh.papertrade.criteria.AuthRoleCriteria;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleCreateDto;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleDto;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 19:58
 */

public interface AuthRoleService extends GenericCrudService<AuthRoleDto, AuthRoleCreateDto, AuthRoleUpdateDto, AuthRoleCriteria, Long> {
}

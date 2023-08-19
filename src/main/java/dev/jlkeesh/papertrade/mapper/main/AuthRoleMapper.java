package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleCreateDto;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleDto;
import dev.jlkeesh.papertrade.dto.main.auth.AuthRoleUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:58
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AuthRoleMapper extends BaseMapper<AuthRole, AuthRoleDto, AuthRoleCreateDto, AuthRoleUpdateDto> {
}

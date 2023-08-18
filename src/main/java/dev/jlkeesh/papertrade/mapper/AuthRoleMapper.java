package dev.jlkeesh.papertrade.mapper;

import dev.jlkeesh.papertrade.domains.auth.AuthRole;
import dev.jlkeesh.papertrade.dto.auth.AuthRoleUpdateDto;
import dev.jlkeesh.papertrade.dto.auth.AuthRoleCreateDto;
import dev.jlkeesh.papertrade.dto.auth.AuthRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:58
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AuthRoleMapper extends BaseMapper<AuthRole, AuthRoleDto, AuthRoleCreateDto, AuthRoleUpdateDto>{
}

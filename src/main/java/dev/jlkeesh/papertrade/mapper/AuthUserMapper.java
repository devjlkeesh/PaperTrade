package dev.jlkeesh.papertrade.mapper;

import dev.jlkeesh.papertrade.domains.auth.AuthRole;
import dev.jlkeesh.papertrade.domains.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.auth.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:58
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = {AuthRoleMapper.class})
public interface AuthUserMapper extends BaseMapper<AuthUser, AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto>{
}

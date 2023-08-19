package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.auth.AuthUser;
import dev.jlkeesh.papertrade.dto.main.auth.AuthUserCreateDto;
import dev.jlkeesh.papertrade.dto.main.auth.AuthUserDto;
import dev.jlkeesh.papertrade.dto.main.auth.AuthUserUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:58
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE, uses = {AuthRoleMapper.class})
public interface AuthUserMapper extends BaseMapper<AuthUser, AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto> {
}

package dev.jlkeesh.papertrade.mapper.reference;

import dev.jlkeesh.papertrade.domains.reference.Country;
import dev.jlkeesh.papertrade.dto.reference.CountryCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CountryDto;
import dev.jlkeesh.papertrade.dto.reference.CountryUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CountryMapper extends BaseMapper<Country, CountryDto, CountryCreateDto, CountryUpdateDto> {
}

package dev.jlkeesh.papertrade.mapper.reference;

import dev.jlkeesh.papertrade.domains.reference.Country;
import dev.jlkeesh.papertrade.dto.reference.CountryCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CountryDto;
import dev.jlkeesh.papertrade.dto.reference.CountryUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.*;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CountryMapper extends BaseMapper<Country, CountryDto, CountryCreateDto, CountryUpdateDto> {
    Country toEntity(CountryDto countryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country partialUpdate(CountryDto countryDto, @MappingTarget Country country);
}

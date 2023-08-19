package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.CountryCriteria;
import dev.jlkeesh.papertrade.dto.reference.CountryCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CountryDto;
import dev.jlkeesh.papertrade.dto.reference.CountryUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface CountryService extends GenericCrudService<CountryDto, CountryCreateDto, CountryUpdateDto, CountryCriteria, Long> {
}

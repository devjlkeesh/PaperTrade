package dev.jlkeesh.papertrade.repository.reference;

import dev.jlkeesh.papertrade.criteria.CountryCriteria;
import dev.jlkeesh.papertrade.domains.reference.Country;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface CountryRepository extends GenericCrudRepository<Country, Long, CountryCriteria> {
}

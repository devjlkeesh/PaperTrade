package dev.jlkeesh.papertrade.repository.reference;

import dev.jlkeesh.papertrade.criteria.CurrencyCriteria;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface CurrencyRepository extends GenericCrudRepository<Currency, Long, CurrencyCriteria> {
}

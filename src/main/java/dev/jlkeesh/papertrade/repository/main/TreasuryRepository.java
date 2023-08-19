package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TreasuryCriteria;
import dev.jlkeesh.papertrade.domains.main.Treasury;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:49
 */
public interface TreasuryRepository extends GenericCrudRepository<Treasury, Long, TreasuryCriteria> {
}

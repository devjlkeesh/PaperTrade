package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TreasureSourceCriteria;
import dev.jlkeesh.papertrade.domains.main.TreasureSource;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface TreasureSourceRepository extends GenericCrudRepository<TreasureSource, Long, TreasureSourceCriteria> {
}

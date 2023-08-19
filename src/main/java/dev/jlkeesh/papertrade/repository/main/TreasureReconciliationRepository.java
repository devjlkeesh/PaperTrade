package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TreasureReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.TreasureReconciliation;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface TreasureReconciliationRepository extends GenericCrudRepository<TreasureReconciliation, Long, TreasureReconciliationCriteria> {
}

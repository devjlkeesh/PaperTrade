package dev.jlkeesh.papertrade.repository.reference;

import dev.jlkeesh.papertrade.criteria.TradeStatusCriteria;
import dev.jlkeesh.papertrade.domains.reference.TradeStatus;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface TradeStatusRepository extends GenericCrudRepository<TradeStatus, Long, TradeStatusCriteria> {
}

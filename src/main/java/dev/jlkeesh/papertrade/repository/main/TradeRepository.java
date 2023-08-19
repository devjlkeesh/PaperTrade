package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TradeCriteria;
import dev.jlkeesh.papertrade.domains.main.Trade;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface TradeRepository extends GenericCrudRepository<Trade, Long, TradeCriteria> {
}

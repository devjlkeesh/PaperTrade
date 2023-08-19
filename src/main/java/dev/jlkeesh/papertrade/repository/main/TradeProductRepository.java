package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TradeProductCriteria;
import dev.jlkeesh.papertrade.domains.main.TradeProduct;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface TradeProductRepository extends GenericCrudRepository<TradeProduct, Long, TradeProductCriteria> {
}

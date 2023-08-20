package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.TreasuryCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.Treasury;
import org.springframework.stereotype.Repository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:49
 */

@Repository
public class TreasuryRepositoryImpl extends GenericDao<Treasury, Long, TreasuryCriteria> implements TreasuryRepository {

}

package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.OrderWagonCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.OrderWagon;
import org.springframework.stereotype.Repository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:23
 */

@Repository
public class OrderWagonRepositoryImpl extends GenericDao<OrderWagon, Long, OrderWagonCriteria> implements OrderWagonRepository {
}

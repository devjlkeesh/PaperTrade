package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.OrderProductCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.OrderProduct;
import org.springframework.stereotype.Repository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 18:52
 */

@Repository
public class OrderProductRepositoryImpl extends GenericDao<OrderProduct, Long, OrderProductCriteria> implements OrderProductRepository {
}

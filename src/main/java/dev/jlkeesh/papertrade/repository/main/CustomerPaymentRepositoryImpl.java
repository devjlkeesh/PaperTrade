package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.CustomerPaymentCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.CustomerPayment;
import org.springframework.stereotype.Repository;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:10
 */

@Repository
public class CustomerPaymentRepositoryImpl extends GenericDao<CustomerPayment, Long, CustomerPaymentCriteria> implements CustomerPaymentRepository {
}

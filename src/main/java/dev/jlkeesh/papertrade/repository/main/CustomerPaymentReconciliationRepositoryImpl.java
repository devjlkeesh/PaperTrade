package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.CustomerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.CustomerPaymentReconciliation;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:37
 */
public class CustomerPaymentReconciliationRepositoryImpl extends GenericDao<CustomerPaymentReconciliation, Long, CustomerPaymentReconciliationCriteria> implements CustomerPaymentReconciliationRepository {
}

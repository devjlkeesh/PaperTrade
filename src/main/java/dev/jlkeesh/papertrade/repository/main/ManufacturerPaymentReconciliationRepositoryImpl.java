package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:49
 */

@Repository
public class ManufacturerPaymentReconciliationRepositoryImpl extends GenericDao<ManufacturerPaymentsReconciliation, Long, ManufacturerPaymentReconciliationCriteria> implements ManufacturerPaymentReconciliationRepository {
    @Override
    protected void defineCriteriaOnQuerying(ManufacturerPaymentReconciliationCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {

        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

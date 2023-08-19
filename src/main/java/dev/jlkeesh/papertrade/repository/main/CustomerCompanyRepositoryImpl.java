package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.CustomerCompanyCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.CustomerCompany;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class CustomerCompanyRepositoryImpl extends GenericDao<CustomerCompany, Long, CustomerCompanyCriteria> implements CustomerCompanyRepository {

    @Override
    protected void defineCriteriaOnQuerying(CustomerCompanyCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getName())) {
            whereCause.add(" lower(t.name) like :name");
            params.put("name", "%" + criteria.getName().toLowerCase() + "%");
        }
        if (BaseUtils.isNotEmpty(criteria.getCustomerId())) {
            whereCause.add("t.customer.id = :countryId");
            params.put("customerId", criteria.getCustomerId());
        }
        if (BaseUtils.isNotEmpty(criteria.getState())) {
            whereCause.add("t.state = :state");
            params.put("state", criteria.getState());
        }

        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

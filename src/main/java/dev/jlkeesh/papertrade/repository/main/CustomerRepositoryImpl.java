package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.CustomerCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.Customer;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class CustomerRepositoryImpl extends GenericDao<Customer, Long, CustomerCriteria> implements CustomerRepository {

    @Override
    protected void defineCriteriaOnQuerying(CustomerCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getName())) {
            whereCause.add(" lower(t.name) like :name");
            params.put("name", "%" + criteria.getName().toLowerCase() + "%");
        }
        if (BaseUtils.isNotEmpty(criteria.getPhone())) {
            whereCause.add("t.phone = :phone");
            params.put("phone",  criteria.getPhone());
        }
        if (BaseUtils.isNotEmpty(criteria.getState())) {
            whereCause.add("t.state = :state");
            params.put("state",  criteria.getState());
        }
        if (BaseUtils.isNotEmpty(criteria.getRegionId())) {
            whereCause.add("t.region.id = :regionId");
            params.put("regionId",  criteria.getRegionId());
        }

        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

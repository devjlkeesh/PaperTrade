package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ProductParameterCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.ProductParameter;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:24
 */

@Repository
public class ProductParameterRepositoryImpl extends GenericDao<ProductParameter, Long, ProductParameterCriteria> implements ProductParameterRepository {

    @Override
    protected void defineCriteriaOnQuerying(ProductParameterCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getProductId())) {
            whereCause.add("t.product.id = :productId");
            params.put("productId", criteria.getProductId());
        }
        if (BaseUtils.isNotEmpty(criteria.getParameterId())) {
            whereCause.add("t.parameter.id = :parameterId");
            params.put("parameterId", criteria.getParameterId());
        }
        if (BaseUtils.isNotEmpty(criteria.getValue())) {
            whereCause.add("t.value = :value");
            params.put("value", criteria.getValue());
        }

        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

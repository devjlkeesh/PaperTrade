package dev.jlkeesh.papertrade.repository.main.auth;

import dev.jlkeesh.papertrade.criteria.AuthRoleCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.auth.AuthRole;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:10
 */
@Repository
public class AuthRoleRepositoryImpl extends GenericDao<AuthRole, Long, AuthRoleCriteria> implements AuthRoleRepository {
    @Override
    protected void defineCriteriaOnQuerying(AuthRoleCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {

        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getAllSearch())) {
            whereCause.add(" lower(t.name) like :all or lower(t.code) like :all");
            params.put("all", "%" + criteria.getAllSearch().toLowerCase() + "%");
        }
        if (BaseUtils.isNotEmpty(criteria.getCode())) {
            whereCause.add("t.code = :code");
            params.put("code", criteria.getCode());
        }
        if (BaseUtils.isNotEmpty(criteria.getIds())) {
            whereCause.add("t.id in (:ids)");
            params.put("ids", criteria.getIds());
        }
        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

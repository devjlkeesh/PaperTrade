package dev.jlkeesh.papertrade.repository.main.auth;

import dev.jlkeesh.papertrade.criteria.AuthUserCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.auth.AuthUser;
import dev.jlkeesh.papertrade.utils.BaseUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 20:07
 */

@Repository
public class AuthUserRepositoryImpl extends GenericDao<AuthUser, Long, AuthUserCriteria> implements AuthUserRepository {
    @Override
    protected void defineCriteriaOnQuerying(AuthUserCriteria criteria, List<String> whereCause, Map<String, Object> params, StringBuilder queryBuilder) {
        if (BaseUtils.isNotEmpty(criteria.getSelfId())) {
            whereCause.add("t.id = :selfId");
            params.put("selfId", criteria.getSelfId());
        }
        if (BaseUtils.isNotEmpty(criteria.getAllSearch())) {
            whereCause.add(" lower(t.fullName) like :all or lower(t.username) like :all or lower(t.phone) like :all");
            params.put("all", "%" + criteria.getAllSearch().toLowerCase() + "%");
        }
        if (BaseUtils.isNotEmpty(criteria.getUsername())) {
            whereCause.add(" lower(t.username) = lower(:username)");
            params.put("username", criteria.getUsername());
        }
        if (BaseUtils.isNotEmpty(criteria.getPhone())) {
            whereCause.add("t.phone = :phone");
            params.put("phone", criteria.getPhone());
        }
        onDefineWhereCause(criteria, whereCause, params, queryBuilder);
    }
}

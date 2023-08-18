package dev.jlkeesh.papertrade.repository;

import dev.jlkeesh.papertrade.criteria.GenericCriteria;
import dev.jlkeesh.papertrade.domains.BaseDomain;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author : Elmurodov Javohir
 * @since : 02/06/23 / 16:27
 */
public interface GenericRepository<T extends BaseDomain, ID extends Serializable, C extends GenericCriteria> extends Repository {
    Optional<T> find(ID id);

    Optional<T> find(C criteria);

    List<T> findAll(C criteria);

    Long getTotalCount(C criteria);

}

package dev.jlkeesh.papertrade.repository;


import dev.jlkeesh.papertrade.criteria.GenericCriteria;
import dev.jlkeesh.papertrade.domains.BaseDomain;

import java.io.Serializable;
import java.util.List;


public interface GenericCrudRepository<T extends BaseDomain, ID extends Serializable, C extends GenericCriteria> extends GenericRepository<T, ID, C> {
    T save(T domain);

    List<T> save(Iterable<T> domains);

    void update(Iterable<T> domains);

    boolean delete(ID id);

}

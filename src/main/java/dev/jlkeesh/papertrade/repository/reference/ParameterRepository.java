package dev.jlkeesh.papertrade.repository.reference;

import dev.jlkeesh.papertrade.criteria.ParameterCriteria;
import dev.jlkeesh.papertrade.domains.reference.Parameter;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface ParameterRepository extends GenericCrudRepository<Parameter, Long, ParameterCriteria> {
}

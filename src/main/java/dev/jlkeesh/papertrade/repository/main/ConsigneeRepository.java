package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ConsigneeCriteria;
import dev.jlkeesh.papertrade.domains.main.Consignee;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface ConsigneeRepository extends GenericCrudRepository<Consignee, Long, ConsigneeCriteria> {
}

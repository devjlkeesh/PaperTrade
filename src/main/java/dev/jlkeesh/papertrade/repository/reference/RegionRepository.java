package dev.jlkeesh.papertrade.repository.reference;

import dev.jlkeesh.papertrade.criteria.RegionCriteria;
import dev.jlkeesh.papertrade.domains.reference.Region;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface RegionRepository extends GenericCrudRepository<Region, Long, RegionCriteria> {
}

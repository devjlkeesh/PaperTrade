package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerCriteria;
import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface ManufacturerRepository extends GenericCrudRepository<Manufacturer, Long, ManufacturerCriteria> {

}

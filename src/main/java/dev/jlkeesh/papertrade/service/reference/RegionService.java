package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.RegionCriteria;
import dev.jlkeesh.papertrade.dto.reference.RegionCreateDto;
import dev.jlkeesh.papertrade.dto.reference.RegionDto;
import dev.jlkeesh.papertrade.dto.reference.RegionUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface RegionService extends GenericCrudService<RegionDto, RegionCreateDto, RegionUpdateDto, RegionCriteria, Long> {
}

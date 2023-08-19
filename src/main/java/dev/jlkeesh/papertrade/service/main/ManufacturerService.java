package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerCriteria;
import dev.jlkeesh.papertrade.dto.main.ManufacturerCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface ManufacturerService extends GenericCrudService<ManufacturerDto, ManufacturerCreateDto, ManufacturerUpdateDto, ManufacturerCriteria, Long> {
}

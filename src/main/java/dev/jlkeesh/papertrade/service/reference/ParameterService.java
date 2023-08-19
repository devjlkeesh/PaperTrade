package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.ParameterCriteria;
import dev.jlkeesh.papertrade.dto.reference.ParameterCreateDto;
import dev.jlkeesh.papertrade.dto.reference.ParameterDto;
import dev.jlkeesh.papertrade.dto.reference.ParameterUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface ParameterService extends GenericCrudService<ParameterDto, ParameterCreateDto, ParameterUpdateDto, ParameterCriteria, Long> {
}

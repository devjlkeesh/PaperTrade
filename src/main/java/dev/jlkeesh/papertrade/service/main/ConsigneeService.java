package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ConsigneeCriteria;
import dev.jlkeesh.papertrade.dto.main.ConsigneeCreateDto;
import dev.jlkeesh.papertrade.dto.main.ConsigneeDto;
import dev.jlkeesh.papertrade.dto.main.ConsigneeUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface ConsigneeService extends GenericCrudService<ConsigneeDto, ConsigneeCreateDto, ConsigneeUpdateDto, ConsigneeCriteria, Long> {
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CustomerCriteria;
import dev.jlkeesh.papertrade.dto.main.CustomerCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerDto;
import dev.jlkeesh.papertrade.dto.main.CustomerUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface CustomerService extends GenericCrudService<CustomerDto, CustomerCreateDto, CustomerUpdateDto, CustomerCriteria, Long> {
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CustomerCompanyCriteria;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyDto;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface CustomerCompanyService extends GenericCrudService<CustomerCompanyDto, CustomerCompanyCreateDto, CustomerCompanyUpdateDto, CustomerCompanyCriteria, Long> {
}

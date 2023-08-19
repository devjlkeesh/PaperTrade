package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ProductParameterCriteria;
import dev.jlkeesh.papertrade.dto.main.ProductParameterCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductParameterDto;
import dev.jlkeesh.papertrade.dto.main.ProductParameterUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface ProductParameterService extends GenericCrudService<ProductParameterDto, ProductParameterCreateDto, ProductParameterUpdateDto, ProductParameterCriteria, Long> {
}

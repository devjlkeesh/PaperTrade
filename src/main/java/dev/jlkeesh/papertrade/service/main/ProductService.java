package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ProductCriteria;
import dev.jlkeesh.papertrade.dto.main.ProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductDto;
import dev.jlkeesh.papertrade.dto.main.ProductUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface ProductService extends GenericCrudService<ProductDto, ProductCreateDto, ProductUpdateDto, ProductCriteria, Long> {
}

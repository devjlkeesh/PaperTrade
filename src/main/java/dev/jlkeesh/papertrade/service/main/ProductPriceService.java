package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ProductPriceCriteria;
import dev.jlkeesh.papertrade.dto.main.ProductPriceCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductPriceDto;
import dev.jlkeesh.papertrade.dto.main.ProductPriceUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface ProductPriceService extends GenericCrudService<ProductPriceDto, ProductPriceCreateDto, ProductPriceUpdateDto, ProductPriceCriteria, Long> {
}

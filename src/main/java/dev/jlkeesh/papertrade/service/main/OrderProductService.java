package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.OrderProductCriteria;
import dev.jlkeesh.papertrade.dto.main.OrderProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderProductDto;
import dev.jlkeesh.papertrade.dto.main.OrderProductUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 18:54
 */

public interface OrderProductService extends GenericCrudService<OrderProductDto, OrderProductCreateDto, OrderProductUpdateDto, OrderProductCriteria, Long> {
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.OrderCriteria;
import dev.jlkeesh.papertrade.dto.main.OrderCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderDto;
import dev.jlkeesh.papertrade.dto.main.OrderUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:55
 */

public interface OrderService extends GenericCrudService<OrderDto, OrderCreateDto, OrderUpdateDto, OrderCriteria, Long> {
}

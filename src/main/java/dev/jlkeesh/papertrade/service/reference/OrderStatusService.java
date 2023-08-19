package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.OrderStatusCriteria;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusCreateDto;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusDto;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface OrderStatusService extends GenericCrudService<OrderStatusDto, OrderStatusCreateDto, OrderStatusUpdateDto, OrderStatusCriteria, Long> {
}

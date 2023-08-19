package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.OrderWagonCriteria;
import dev.jlkeesh.papertrade.dto.main.OrderWagonCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderWagonDto;
import dev.jlkeesh.papertrade.dto.main.OrderWagonUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:24
 */
public interface OrderWagonService extends GenericCrudService<OrderWagonDto, OrderWagonCreateDto, OrderWagonUpdateDto, OrderWagonCriteria, Long> {
}

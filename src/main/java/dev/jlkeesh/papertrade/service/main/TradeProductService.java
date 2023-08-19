package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TradeProductCriteria;
import dev.jlkeesh.papertrade.dto.main.TradeProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.TradeProductDto;
import dev.jlkeesh.papertrade.dto.main.TradeProductUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface TradeProductService extends GenericCrudService<TradeProductDto, TradeProductCreateDto, TradeProductUpdateDto, TradeProductCriteria, Long> {
}

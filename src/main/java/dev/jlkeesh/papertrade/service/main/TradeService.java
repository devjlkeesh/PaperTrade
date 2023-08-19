package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TradeCriteria;
import dev.jlkeesh.papertrade.dto.main.TradeCreateDto;
import dev.jlkeesh.papertrade.dto.main.TradeDto;
import dev.jlkeesh.papertrade.dto.main.TradeUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface TradeService extends GenericCrudService<TradeDto, TradeCreateDto, TradeUpdateDto, TradeCriteria, Long> {
}

package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.TradeStatusCriteria;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusCreateDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface TradeStatusService extends GenericCrudService<TradeStatusDto, TradeStatusCreateDto, TradeStatusUpdateDto, TradeStatusCriteria, Long> {
}

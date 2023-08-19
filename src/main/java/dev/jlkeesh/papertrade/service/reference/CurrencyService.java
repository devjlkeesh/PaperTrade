package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.CurrencyCriteria;
import dev.jlkeesh.papertrade.dto.reference.CurrencyCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface CurrencyService extends GenericCrudService<CurrencyDto, CurrencyCreateDto, CurrencyUpdateDto, CurrencyCriteria, Long> {
}

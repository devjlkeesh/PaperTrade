package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TreasuryCriteria;
import dev.jlkeesh.papertrade.dto.main.TreasuryCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasuryDto;
import dev.jlkeesh.papertrade.dto.main.TreasuryUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:51
 */
public interface TreasuryService extends GenericCrudService<TreasuryDto, TreasuryCreateDto, TreasuryUpdateDto, TreasuryCriteria, Long> {
}

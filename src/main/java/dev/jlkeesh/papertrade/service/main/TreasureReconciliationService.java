package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TreasureReconciliationCriteria;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface TreasureReconciliationService extends GenericCrudService<TreasureReconciliationDto, TreasureReconciliationCreateDto, TreasureReconciliationUpdateDto, TreasureReconciliationCriteria, Long> {
}

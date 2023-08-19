package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TreasureSourceCriteria;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceDto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface TreasureSourceService extends GenericCrudService<TreasureSourceDto, TreasureSourceCreateDto, TreasureSourceUpdateDto, TreasureSourceCriteria, Long> {
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ExpenseCategoryCriteria;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryCreateDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface ExpenseCategoryService extends GenericCrudService<ExpenseCategoryDto, ExpenseCategoryCreateDto, ExpenseCategoryUpdateDto, ExpenseCategoryCriteria, Long> {
}

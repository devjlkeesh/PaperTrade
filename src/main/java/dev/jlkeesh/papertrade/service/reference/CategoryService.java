package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.CategoryCriteria;
import dev.jlkeesh.papertrade.dto.reference.CategoryCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CategoryDto;
import dev.jlkeesh.papertrade.dto.reference.CategoryUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface CategoryService extends GenericCrudService<CategoryDto, CategoryCreateDto, CategoryUpdateDto, CategoryCriteria, Long> {
}

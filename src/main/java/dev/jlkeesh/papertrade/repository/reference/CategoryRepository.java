package dev.jlkeesh.papertrade.repository.reference;

import dev.jlkeesh.papertrade.criteria.CategoryCriteria;
import dev.jlkeesh.papertrade.domains.reference.Category;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface CategoryRepository extends GenericCrudRepository<Category, Long, CategoryCriteria> {
}

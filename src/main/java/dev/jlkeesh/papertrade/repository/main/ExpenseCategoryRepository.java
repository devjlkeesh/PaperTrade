package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ExpenseCategoryCriteria;
import dev.jlkeesh.papertrade.domains.main.ExpenseCategory;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:23
 */
public interface ExpenseCategoryRepository extends GenericCrudRepository<ExpenseCategory, Long, ExpenseCategoryCriteria> {
}

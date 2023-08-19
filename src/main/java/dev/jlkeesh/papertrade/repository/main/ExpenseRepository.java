package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ExpenseCriteria;
import dev.jlkeesh.papertrade.domains.main.Expense;
import dev.jlkeesh.papertrade.repository.GenericCrudRepository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:56
 */

public interface ExpenseRepository extends GenericCrudRepository<Expense, Long, ExpenseCriteria> {
}

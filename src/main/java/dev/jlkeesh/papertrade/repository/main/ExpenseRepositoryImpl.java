package dev.jlkeesh.papertrade.repository.main;

import dev.jlkeesh.papertrade.criteria.ExpenseCriteria;
import dev.jlkeesh.papertrade.dao.GenericDao;
import dev.jlkeesh.papertrade.domains.main.Expense;
import org.springframework.stereotype.Repository;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:56
 */

@Repository
public class ExpenseRepositoryImpl extends GenericDao<Expense, Long, ExpenseCriteria> implements ExpenseRepository {
}

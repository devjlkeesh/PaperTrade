package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ExpenseCriteria;
import dev.jlkeesh.papertrade.dto.main.ExpenseCreateDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:58
 */

public interface ExpenseService extends GenericCrudService<ExpenseDto, ExpenseCreateDto, ExpenseUpdateDto, ExpenseCriteria, Long> {
}

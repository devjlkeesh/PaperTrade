package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.Expense;
import dev.jlkeesh.papertrade.dto.main.ExpenseCreateDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:55
 */

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ExpenseMapper extends BaseMapper<Expense, ExpenseDto, ExpenseCreateDto, ExpenseUpdateDto> {
}

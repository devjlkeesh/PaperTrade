package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.ExpenseCategory;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryCreateDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ExpenseCategoryMapper extends BaseMapper<ExpenseCategory, ExpenseCategoryDto, ExpenseCategoryCreateDto, ExpenseCategoryUpdateDto> {
}

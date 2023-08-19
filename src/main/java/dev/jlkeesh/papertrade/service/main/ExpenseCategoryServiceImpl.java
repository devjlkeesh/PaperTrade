package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ExpenseCategoryCriteria;
import dev.jlkeesh.papertrade.domains.main.ExpenseCategory;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryCreateDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.ExpenseCategoryMapper;
import dev.jlkeesh.papertrade.repository.main.ExpenseCategoryRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Objects;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:26
 */

@Service
public class ExpenseCategoryServiceImpl extends AbstractService<ExpenseCategoryRepository, ExpenseCategoryMapper> implements ExpenseCategoryService {
    protected ExpenseCategoryServiceImpl(ExpenseCategoryRepository repository, ExpenseCategoryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<ExpenseCategoryDto>>> getAll(@NonNull ExpenseCategoryCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<ExpenseCategory> expenseCategories = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(expenseCategories), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ExpenseCategoryDto>> get(@NonNull Long id) {
        ExpenseCategory expenseCategory = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(expenseCategory)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ExpenseCategoryCreateDto dto) {
        repository.find(ExpenseCategoryCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(expenseCategory -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        ExpenseCategory expenseCategory = mapper.fromCreateDto(dto);
        if (Objects.nonNull(dto.parentId())) {
            ExpenseCategory parentExpenseCategory = repository.find(dto.parentId())
                    .orElseThrow(ResourceNotFoundException::new);
            expenseCategory.setParent(parentExpenseCategory);
        }

        repository.save(expenseCategory);
        return new ResponseEntity<>(new Data<>(expenseCategory.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ExpenseCategoryUpdateDto dto) {
        ExpenseCategory expenseCategory = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, expenseCategory));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ExpenseCriteria;
import dev.jlkeesh.papertrade.domains.main.Expense;
import dev.jlkeesh.papertrade.dto.main.ExpenseCreateDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.ExpenseMapper;
import dev.jlkeesh.papertrade.repository.main.ExpenseRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 22:58
 */

@Service
public class ExpenseServiceImpl extends AbstractService<ExpenseRepository, ExpenseMapper> implements ExpenseService {

    protected ExpenseServiceImpl(ExpenseRepository repository, ExpenseMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<ExpenseDto>>> getAll(@NonNull ExpenseCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Expense> expenses = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(expenses), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ExpenseDto>> get(@NonNull Long id) {
        Expense expense = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(expense)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ExpenseCreateDto dto) {
        repository.find(ExpenseCriteria
                        .childBuilder()
                        .expenseCategoryId(dto.expenseCategoryId())
                        .orderWagonId(dto.orderWagonId())
                        .build())
                .ifPresent(consignee -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Expense expense = mapper.fromCreateDto(dto);
        repository.save(expense);
        return new ResponseEntity<>(new Data<>(expense.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ExpenseUpdateDto dto) {
        Expense expense = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, expense));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

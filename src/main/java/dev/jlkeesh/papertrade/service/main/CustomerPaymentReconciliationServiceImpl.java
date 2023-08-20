package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CustomerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.CustomerPaymentReconciliation;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconcilationDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconciliationUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.CustomerPaymentReconciliationMapper;
import dev.jlkeesh.papertrade.repository.main.CustomerPaymentReconciliationRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:40
 */

@Service
public class CustomerPaymentReconciliationServiceImpl extends AbstractService<CustomerPaymentReconciliationRepository, CustomerPaymentReconciliationMapper> implements CustomerPaymentReconciliationService {

    protected CustomerPaymentReconciliationServiceImpl(CustomerPaymentReconciliationRepository repository, CustomerPaymentReconciliationMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<CustomerPaymentReconcilationDto>>> getAll(@NonNull CustomerPaymentReconciliationCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<CustomerPaymentReconciliation> customerPaymentReconciliations = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(customerPaymentReconciliations), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CustomerPaymentReconcilationDto>> get(@NonNull Long id) {
        CustomerPaymentReconciliation customerPaymentReconciliation = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(customerPaymentReconciliation)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull CustomerPaymentReconciliationCreateDto dto) {
        repository.find(CustomerPaymentReconciliationCriteria
                        .childBuilder()
                        .customerId(dto.customerId())
                        .build())
                .ifPresent(expenseCategory -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        CustomerPaymentReconciliation customerPaymentReconciliation = mapper.fromCreateDto(dto);
        repository.save(customerPaymentReconciliation);
        return new ResponseEntity<>(new Data<>(customerPaymentReconciliation.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull CustomerPaymentReconciliationUpdateDto dto) {
        CustomerPaymentReconciliation customerPaymentReconciliation = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, customerPaymentReconciliation));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

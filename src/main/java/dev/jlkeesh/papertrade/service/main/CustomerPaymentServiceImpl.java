package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CustomerPaymentCriteria;
import dev.jlkeesh.papertrade.domains.main.CustomerPayment;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.CustomerPaymentMapper;
import dev.jlkeesh.papertrade.repository.main.CustomerPaymentRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:12
 */

@Service
public class CustomerPaymentServiceImpl extends AbstractService<CustomerPaymentRepository, CustomerPaymentMapper> implements CustomerPaymentService {

    protected CustomerPaymentServiceImpl(CustomerPaymentRepository repository, CustomerPaymentMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<CustomerPaymentDto>>> getAll(@NonNull CustomerPaymentCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<CustomerPayment> customerPayments = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(customerPayments), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CustomerPaymentDto>> get(@NonNull Long id) {
        CustomerPayment customerPayment = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(customerPayment)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull CustomerPaymentCreateDto dto) {
        repository.find(CustomerPaymentCriteria
                        .childBuilder()
                        .customerId(dto.customerId())
                        .customerCompanyId(dto.customerCompanyId())
                        .consigneeId(dto.consigneeId())
                        .build())
                .ifPresent(expenseCategory -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        CustomerPayment customerPayment = mapper.fromCreateDto(dto);
        repository.save(customerPayment);
        return new ResponseEntity<>(new Data<>(customerPayment.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull CustomerPaymentUpdateDto dto) {
        CustomerPayment customerPayment = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, customerPayment));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CustomerCompanyCriteria;
import dev.jlkeesh.papertrade.domains.main.Customer;
import dev.jlkeesh.papertrade.domains.main.CustomerCompany;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyDto;
import dev.jlkeesh.papertrade.dto.main.CustomerCompanyUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.State;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.CustomerCompanyMapper;
import dev.jlkeesh.papertrade.repository.main.CustomerCompanyRepository;
import dev.jlkeesh.papertrade.repository.main.CustomerRepository;
import dev.jlkeesh.papertrade.repository.reference.RegionRepositoryImpl;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:26
 */

@Service
public class CustomerCompanyServiceImpl extends AbstractService<CustomerCompanyRepository, CustomerCompanyMapper> implements CustomerCompanyService {

    private final CustomerRepository customerRepository;

    protected CustomerCompanyServiceImpl(CustomerCompanyRepository repository, CustomerCompanyMapper mapper, RegionRepositoryImpl regionRepository, CustomerRepository customerRepository) {
        super(repository, mapper);
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<Data<List<CustomerCompanyDto>>> getAll(@NonNull CustomerCompanyCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<CustomerCompany> customerCompanyList = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(customerCompanyList), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CustomerCompanyDto>> get(@NonNull Long id) {
        CustomerCompany customerCompany = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(customerCompany)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull CustomerCompanyCreateDto dto) {
        repository.find(CustomerCompanyCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(customer -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Customer customer = customerRepository.find(dto.customerId()).orElseThrow(ResourceNotFoundException::new);
        CustomerCompany customerCompany = mapper.fromCreateDto(dto);
        customerCompany.setCustomer(customer);
        customerCompany.setState(State.ACTIVE);
        repository.save(customerCompany);
        return new ResponseEntity<>(new Data<>(customerCompany.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull CustomerCompanyUpdateDto dto) {
        CustomerCompany customerCompany = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        customerCompany = mapper.partialUpdate(dto, customerCompany);
        if (dto.customerId() != null) {
            Customer customer = customerRepository.find(dto.customerId()).orElseThrow(ResourceNotFoundException::new);
            customerCompany.setCustomer(customer);
        }
        repository.save(customerCompany);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

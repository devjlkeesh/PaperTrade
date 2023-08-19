package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CustomerCriteria;
import dev.jlkeesh.papertrade.domains.main.Customer;
import dev.jlkeesh.papertrade.domains.reference.Region;
import dev.jlkeesh.papertrade.dto.main.CustomerCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerDto;
import dev.jlkeesh.papertrade.dto.main.CustomerUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.State;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.CustomerMapper;
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
public class CustomerServiceImpl extends AbstractService<CustomerRepository, CustomerMapper> implements CustomerService {
    private final RegionRepositoryImpl regionRepository;

    protected CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper, RegionRepositoryImpl regionRepository) {
        super(repository, mapper);
        this.regionRepository = regionRepository;
    }

    @Override
    public ResponseEntity<Data<List<CustomerDto>>> getAll(@NonNull CustomerCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Customer> customerList = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(customerList), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CustomerDto>> get(@NonNull Long id) {
        Customer customer = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(customer)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull CustomerCreateDto dto) {
        repository.find(CustomerCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(customer -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Region region = regionRepository.find(dto.regionId()).orElseThrow(ResourceNotFoundException::new);
        Customer customer = mapper.fromCreateDto(dto);
        customer.setRegion(region);
        customer.setState(State.ACTIVE);
        repository.save(customer);
        return new ResponseEntity<>(new Data<>(customer.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull CustomerUpdateDto dto) {
        Customer customer = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        customer = mapper.partialUpdate(dto, customer);
        if (dto.regionId()!=null) {
            Region region = regionRepository.find(dto.regionId()).orElseThrow(ResourceNotFoundException::new);
            customer.setRegion(region);
        }
        repository.save(customer);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

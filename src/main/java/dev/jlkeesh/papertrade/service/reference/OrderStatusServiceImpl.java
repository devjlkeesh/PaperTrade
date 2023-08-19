package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.OrderStatusCriteria;
import dev.jlkeesh.papertrade.domains.reference.OrderStatus;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusCreateDto;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusDto;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.reference.OrderStatusMapper;
import dev.jlkeesh.papertrade.repository.reference.OrderStatusRepository;
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
public class OrderStatusServiceImpl extends AbstractService<OrderStatusRepository, OrderStatusMapper> implements OrderStatusService {
    protected OrderStatusServiceImpl(OrderStatusRepository repository, OrderStatusMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<OrderStatusDto>>> getAll(@NonNull OrderStatusCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<OrderStatus> countries = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(countries), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<OrderStatusDto>> get(@NonNull Long id) {
        OrderStatus country = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(country)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull OrderStatusCreateDto dto) {
        repository.find(OrderStatusCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(country -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        OrderStatus country = mapper.fromCreateDto(dto);
        repository.save(country);
        return new ResponseEntity<>(new Data<>(country.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull OrderStatusUpdateDto dto) {
        OrderStatus country = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, country));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

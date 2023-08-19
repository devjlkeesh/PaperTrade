package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.OrderCriteria;
import dev.jlkeesh.papertrade.domains.main.Consignee;
import dev.jlkeesh.papertrade.domains.main.Order;
import dev.jlkeesh.papertrade.dto.main.OrderCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderDto;
import dev.jlkeesh.papertrade.dto.main.OrderUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.OrderMapper;
import dev.jlkeesh.papertrade.repository.main.OrderRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 14:56
 */

@Service
public class OrderServiceImpl extends AbstractService<OrderRepository, OrderMapper> implements OrderService {
    protected OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<OrderDto>>> getAll(@NonNull OrderCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Order> orders = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(orders), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<OrderDto>> get(@NonNull Long id) {
        Order order = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(order)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull OrderCreateDto dto) {
        repository.find(OrderCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(consignee -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Order order = mapper.fromCreateDto(dto);
        repository.save(order);
        return new ResponseEntity<>(new Data<>(order.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull OrderUpdateDto dto) {
        Order order = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, order));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

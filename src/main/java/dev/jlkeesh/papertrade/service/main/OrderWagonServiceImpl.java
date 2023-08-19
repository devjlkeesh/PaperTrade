package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.OrderWagonCriteria;
import dev.jlkeesh.papertrade.domains.main.OrderWagon;
import dev.jlkeesh.papertrade.dto.main.OrderWagonCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderWagonDto;
import dev.jlkeesh.papertrade.dto.main.OrderWagonUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.OrderWagonMapper;
import dev.jlkeesh.papertrade.repository.main.OrderWagonRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 21:25
 */

@Service
public class OrderWagonServiceImpl extends AbstractService<OrderWagonRepository, OrderWagonMapper> implements OrderWagonService {

    protected OrderWagonServiceImpl(OrderWagonRepository repository, OrderWagonMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<OrderWagonDto>>> getAll(@NonNull OrderWagonCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<OrderWagon> orderWagons = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(orderWagons), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<OrderWagonDto>> get(@NonNull Long id) {
        OrderWagon orderWagon = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(orderWagon)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull OrderWagonCreateDto dto) {
        repository.find(OrderWagonCriteria
                        .childBuilder()
                        .orderProductId(dto.orderProductId())
                        .build())
                .ifPresent(consignee -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        OrderWagon orderWagon = mapper.fromCreateDto(dto);
        repository.save(orderWagon);
        return new ResponseEntity<>(new Data<>(orderWagon.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull OrderWagonUpdateDto dto) {
        OrderWagon orderWagon = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, orderWagon));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

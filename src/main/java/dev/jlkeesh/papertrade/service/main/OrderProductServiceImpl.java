package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.OrderProductCriteria;
import dev.jlkeesh.papertrade.domains.main.OrderProduct;
import dev.jlkeesh.papertrade.dto.main.OrderProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderProductDto;
import dev.jlkeesh.papertrade.dto.main.OrderProductUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.OrderProductMapper;
import dev.jlkeesh.papertrade.repository.main.OrderProductRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 18:55
 */

@Service
public class OrderProductServiceImpl extends AbstractService<OrderProductRepository, OrderProductMapper> implements OrderProductService {

    protected OrderProductServiceImpl(OrderProductRepository repository, OrderProductMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<OrderProductDto>>> getAll(@NonNull OrderProductCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<OrderProduct> orderProducts = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(orderProducts), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<OrderProductDto>> get(@NonNull Long id) {
        OrderProduct orderProduct = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(orderProduct)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull OrderProductCreateDto dto) {
        repository.find(OrderProductCriteria
                        .childBuilder()
                        .orderId(dto.orderId())
                        .productId(dto.productId())
                        .build())
                .ifPresent(consignee -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        OrderProduct orderProduct = mapper.fromCreateDto(dto);
        repository.save(orderProduct);
        return new ResponseEntity<>(new Data<>(orderProduct.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull OrderProductUpdateDto dto) {
        OrderProduct orderProduct = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, orderProduct));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

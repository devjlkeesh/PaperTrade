package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductCriteria;
import dev.jlkeesh.papertrade.domains.main.InventoryProduct;
import dev.jlkeesh.papertrade.dto.main.InventoryProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.InventoryProductMapper;
import dev.jlkeesh.papertrade.repository.main.InventoryProductRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 11:11
 */

@Service
public class InventoryProductServiceImpl extends AbstractService<InventoryProductRepository, InventoryProductMapper> implements InventoryProductService {

    protected InventoryProductServiceImpl(InventoryProductRepository repository, InventoryProductMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<InventoryProductDto>>> getAll(@NonNull InventoryProductCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<InventoryProduct> inventoryProducts = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(inventoryProducts), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<InventoryProductDto>> get(@NonNull Long id) {
        InventoryProduct inventoryProduct = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(inventoryProduct)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull InventoryProductCreateDto dto) {
        repository.find(InventoryProductCriteria
                        .childBuilder()
                        .inventoryId(dto.inventoryId())
                        .build())
                .ifPresent(inventory -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        InventoryProduct inventoryProduct = mapper.fromCreateDto(dto);
        repository.save(inventoryProduct);
        return new ResponseEntity<>(new Data<>(inventoryProduct.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull InventoryProductUpdateDto dto) {
        InventoryProduct inventoryProduct = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, inventoryProduct));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

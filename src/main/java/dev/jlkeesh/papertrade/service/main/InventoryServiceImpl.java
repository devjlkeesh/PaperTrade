package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.InventoryCriteria;
import dev.jlkeesh.papertrade.domains.main.Inventory;
import dev.jlkeesh.papertrade.dto.main.InventoryCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryDto;
import dev.jlkeesh.papertrade.dto.main.InventoryUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.State;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.InventoryMapper;
import dev.jlkeesh.papertrade.repository.main.InventoryRepository;
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
public class InventoryServiceImpl extends AbstractService<InventoryRepository, InventoryMapper> implements InventoryService {
    protected InventoryServiceImpl(InventoryRepository repository, InventoryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<InventoryDto>>> getAll(@NonNull InventoryCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Inventory> inventoryList = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(inventoryList), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<InventoryDto>> get(@NonNull Long id) {
        Inventory inventory = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(inventory)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull InventoryCreateDto dto) {
        repository.find(InventoryCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(inventory -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Inventory inventory = mapper.fromCreateDto(dto);
        inventory.setState(State.ACTIVE);
        repository.save(inventory);
        return new ResponseEntity<>(new Data<>(inventory.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull InventoryUpdateDto dto) {
        Inventory inventory = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, inventory));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

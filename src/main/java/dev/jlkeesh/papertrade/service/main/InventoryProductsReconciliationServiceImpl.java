package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.InventoryProductsReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.Inventory;
import dev.jlkeesh.papertrade.domains.main.InventoryProductsReconciliation;
import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.domains.main.Product;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.InventoryProductsReconciliationMapper;
import dev.jlkeesh.papertrade.repository.main.InventoryProductsReconciliationRepository;
import dev.jlkeesh.papertrade.repository.main.InventoryRepository;
import dev.jlkeesh.papertrade.repository.main.ManufacturerRepository;
import dev.jlkeesh.papertrade.repository.main.ProductRepository;
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
public class InventoryProductsReconciliationServiceImpl extends AbstractService<InventoryProductsReconciliationRepository, InventoryProductsReconciliationMapper> implements InventoryProductsReconciliationService {

    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;
    private final ManufacturerRepository manufacturerRepository;

    protected InventoryProductsReconciliationServiceImpl(InventoryProductsReconciliationRepository repository, InventoryProductsReconciliationMapper mapper, ProductRepository productRepository, InventoryRepository inventoryRepository, ManufacturerRepository manufacturerRepository) {
        super(repository, mapper);
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public ResponseEntity<Data<List<InventoryProductsReconciliationDto>>> getAll(@NonNull InventoryProductsReconciliationCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<InventoryProductsReconciliation> inventoryProductsReconciliations = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(inventoryProductsReconciliations), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<InventoryProductsReconciliationDto>> get(@NonNull Long id) {
        InventoryProductsReconciliation inventoryProductsReconciliation = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(inventoryProductsReconciliation)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull InventoryProductsReconciliationCreateDto dto) {
        // TODO: 19/08/23 any check ?
        Product product = productRepository.find(dto.getProductId()).orElseThrow(ResourceNotFoundException::new);
        Inventory inventory = inventoryRepository.find(dto.getInventoryId()).orElseThrow(ResourceNotFoundException::new);
        Manufacturer manufacturer = manufacturerRepository.find(dto.getManufacturerId()).orElseThrow(ResourceNotFoundException::new);
        InventoryProductsReconciliation inventoryProductsReconciliation = mapper.fromCreateDto(dto);
        inventoryProductsReconciliation.setProduct(product);
        inventoryProductsReconciliation.setInventory(inventory);
        inventoryProductsReconciliation.setManufacturer(manufacturer);
        repository.save(inventoryProductsReconciliation);
        return new ResponseEntity<>(new Data<>(inventoryProductsReconciliation.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull InventoryProductsReconciliationUpdateDto dto) {
        InventoryProductsReconciliation inventoryProductsReconciliation = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, inventoryProductsReconciliation));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

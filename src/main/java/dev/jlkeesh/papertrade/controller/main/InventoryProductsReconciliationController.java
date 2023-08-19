package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.InventoryProductsReconciliationCriteria;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductsReconciliationUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.InventoryProductsReconciliationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 18/08/23 / 19:57
 */

@RestController
public class InventoryProductsReconciliationController extends AbstractController<InventoryProductsReconciliationService> {
    protected InventoryProductsReconciliationController(InventoryProductsReconciliationService service) {
        super(service);
    }

    @GetMapping(PATH + "/inventory-products-reconciliation/{id}")
    public ResponseEntity<Data<InventoryProductsReconciliationDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/inventory-products-reconciliation")
    public ResponseEntity<Data<List<InventoryProductsReconciliationDto>>> getAll(InventoryProductsReconciliationCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/inventory-products-reconciliation")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody InventoryProductsReconciliationCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/inventory-products-reconciliation/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/inventory-products-reconciliation")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody InventoryProductsReconciliationUpdateDto dto) {
        return service.update(dto);
    }
}

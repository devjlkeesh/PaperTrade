package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.InventoryProductCriteria;
import dev.jlkeesh.papertrade.dto.main.InventoryProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductDto;
import dev.jlkeesh.papertrade.dto.main.InventoryProductUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.InventoryProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 11:16
 */

@RestController
public class InventoryProductController extends AbstractController<InventoryProductService> {

    protected InventoryProductController(InventoryProductService service) {
        super(service);
    }

    @GetMapping(PATH + "/inventory-product/{id}")
    public ResponseEntity<Data<InventoryProductDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/inventory-product")
    public ResponseEntity<Data<List<InventoryProductDto>>> getAll(InventoryProductCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/inventory-product")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody InventoryProductCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/inventory-product/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(PATH + "/inventory-product")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody InventoryProductUpdateDto dto) {
        return service.update(dto);
    }
}

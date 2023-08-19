package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.OrderCriteria;
import dev.jlkeesh.papertrade.criteria.OrderProductCriteria;
import dev.jlkeesh.papertrade.dto.main.*;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.OrderProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 19:19
 */

@RestController
public class OrderProductController extends AbstractController<OrderProductService> {
    protected OrderProductController(OrderProductService service) {
        super(service);
    }

    @GetMapping(PATH + "/order-product/{id}")
    public ResponseEntity<Data<OrderProductDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/order-product")
    public ResponseEntity<Data<List<OrderProductDto>>> getAll(OrderProductCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/order-product")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody OrderProductCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/order-product/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(PATH + "/order-product")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody OrderProductUpdateDto dto) {
        return service.update(dto);
    }
}

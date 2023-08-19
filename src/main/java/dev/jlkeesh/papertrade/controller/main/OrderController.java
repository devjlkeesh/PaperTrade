package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.OrderCriteria;
import dev.jlkeesh.papertrade.dto.main.OrderCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderDto;
import dev.jlkeesh.papertrade.dto.main.OrderUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 17:31
 */

@RestController
public class OrderController extends AbstractController<OrderService> {
    protected OrderController(OrderService service) {
        super(service);
    }

    @GetMapping(PATH + "/order/{id}")
    public ResponseEntity<Data<OrderDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/order")
    public ResponseEntity<Data<List<OrderDto>>> getAll(OrderCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/order")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody OrderCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/order/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(PATH + "/order")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody OrderUpdateDto dto) {
        return service.update(dto);
    }
}

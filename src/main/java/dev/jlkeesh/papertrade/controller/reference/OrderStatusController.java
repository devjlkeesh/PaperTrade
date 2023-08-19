package dev.jlkeesh.papertrade.controller.reference;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.OrderStatusCriteria;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusCreateDto;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusDto;
import dev.jlkeesh.papertrade.dto.reference.OrderStatusUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.reference.OrderStatusService;
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
public class OrderStatusController extends AbstractController<OrderStatusService> {
    protected OrderStatusController(OrderStatusService service) {
        super(service);
    }

    @GetMapping(PATH + "/order-status/{id}")
    public ResponseEntity<Data<OrderStatusDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/order-status")
    public ResponseEntity<Data<List<OrderStatusDto>>> getAll(OrderStatusCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/order-status")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody OrderStatusCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/order-status/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/order-status")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody OrderStatusUpdateDto dto) {
        return service.update(dto);
    }
}

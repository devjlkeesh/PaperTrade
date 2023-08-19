package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.OrderWagonCriteria;
import dev.jlkeesh.papertrade.dto.main.OrderWagonCreateDto;
import dev.jlkeesh.papertrade.dto.main.OrderWagonDto;
import dev.jlkeesh.papertrade.dto.main.OrderWagonUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.OrderWagonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:08
 */

@RestController
public class OrderWagonController extends AbstractController<OrderWagonService> {

    protected OrderWagonController(OrderWagonService service) {
        super(service);
    }

    @GetMapping(PATH + "/order-wagon/{id}")
    public ResponseEntity<Data<OrderWagonDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/order-wagon")
    public ResponseEntity<Data<List<OrderWagonDto>>> getAll(OrderWagonCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/order-wagon")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody OrderWagonCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/order-wagon/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(PATH + "/order-wagon")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody OrderWagonUpdateDto dto) {
        return service.update(dto);
    }
}

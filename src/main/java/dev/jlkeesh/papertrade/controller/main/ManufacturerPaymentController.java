package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentCriteria;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.ManufacturerPaymentService;
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
public class ManufacturerPaymentController extends AbstractController<ManufacturerPaymentService> {
    protected ManufacturerPaymentController(ManufacturerPaymentService service) {
        super(service);
    }

    @GetMapping(PATH + "/manufacturer-payment/{id}")
    public ResponseEntity<Data<ManufacturerPaymentDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/manufacturer-payment")
    public ResponseEntity<Data<List<ManufacturerPaymentDto>>> getAll(ManufacturerPaymentCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/manufacturer-payment")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody ManufacturerPaymentCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/manufacturer-payment/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/manufacturer-payment")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody ManufacturerPaymentUpdateDto dto) {
        return service.update(dto);
    }
}

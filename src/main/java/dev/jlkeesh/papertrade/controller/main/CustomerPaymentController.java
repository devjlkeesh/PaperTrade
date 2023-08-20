package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.CustomerPaymentCriteria;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.CustomerPaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 20/08/2023 - 09:17
 */

@RestController
public class CustomerPaymentController extends AbstractController<CustomerPaymentService> {

    protected CustomerPaymentController(CustomerPaymentService service) {
        super(service);
    }

    @GetMapping(PATH + "/customer-payment/{id}")
    public ResponseEntity<Data<CustomerPaymentDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/customer-payment")
    public ResponseEntity<Data<List<CustomerPaymentDto>>> getAll(CustomerPaymentCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/customer-payment")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody CustomerPaymentCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/customer-payment/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(PATH + "/customer-payment")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody CustomerPaymentUpdateDto dto) {
        return service.update(dto);
    }
}

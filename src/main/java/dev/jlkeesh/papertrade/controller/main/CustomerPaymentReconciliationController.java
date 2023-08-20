package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.CustomerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconcilationDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerPaymentReconciliationUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.CustomerPaymentReconciliationService;
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
public class CustomerPaymentReconciliationController extends AbstractController<CustomerPaymentReconciliationService> {

    protected CustomerPaymentReconciliationController(CustomerPaymentReconciliationService service) {
        super(service);
    }

    @GetMapping(PATH + "/customer-payment-reconciliation/{id}")
    public ResponseEntity<Data<CustomerPaymentReconcilationDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/customer-payment-reconciliation")
    public ResponseEntity<Data<List<CustomerPaymentReconcilationDto>>> getAll(CustomerPaymentReconciliationCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/customer-payment-reconciliation")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody CustomerPaymentReconciliationCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/customer-payment-reconciliation/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(PATH + "/customer-payment-reconciliation")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody CustomerPaymentReconciliationUpdateDto dto) {
        return service.update(dto);
    }
}

package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.CustomerCriteria;
import dev.jlkeesh.papertrade.dto.main.CustomerCreateDto;
import dev.jlkeesh.papertrade.dto.main.CustomerDto;
import dev.jlkeesh.papertrade.dto.main.CustomerUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.CustomerService;
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
public class CustomerController extends AbstractController<CustomerService> {
    protected CustomerController(CustomerService service) {
        super(service);
    }

    @GetMapping(PATH + "/customer/{id}")
    public ResponseEntity<Data<CustomerDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/customer")
    public ResponseEntity<Data<List<CustomerDto>>> getAll(CustomerCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/customer")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody CustomerCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/customer/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/customer")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody CustomerUpdateDto dto) {
        return service.update(dto);
    }
}

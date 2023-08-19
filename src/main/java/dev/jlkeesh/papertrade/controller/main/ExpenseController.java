package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.ExpenseCriteria;
import dev.jlkeesh.papertrade.dto.main.ExpenseCreateDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.ExpenseService;
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
public class ExpenseController extends AbstractController<ExpenseService> {

    protected ExpenseController(ExpenseService service) {
        super(service);
    }

    @GetMapping(PATH + "/expense/{id}")
    public ResponseEntity<Data<ExpenseDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/expense")
    public ResponseEntity<Data<List<ExpenseDto>>> getAll(ExpenseCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/expense")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody ExpenseCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/expense/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(PATH + "/expense")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody ExpenseUpdateDto dto) {
        return service.update(dto);
    }
}

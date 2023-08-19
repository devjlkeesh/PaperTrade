package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.ExpenseCategoryCriteria;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryCreateDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryDto;
import dev.jlkeesh.papertrade.dto.main.ExpenseCategoryUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.ExpenseCategoryService;
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
public class ExpenseCategoryController extends AbstractController<ExpenseCategoryService> {
    protected ExpenseCategoryController(ExpenseCategoryService service) {
        super(service);
    }

    @GetMapping(PATH + "/expense-category/{id}")
    public ResponseEntity<Data<ExpenseCategoryDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/expense-category")
    public ResponseEntity<Data<List<ExpenseCategoryDto>>> getAll(ExpenseCategoryCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/expense-category")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody ExpenseCategoryCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/expense-category/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/expense-category")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody ExpenseCategoryUpdateDto dto) {
        return service.update(dto);
    }
}

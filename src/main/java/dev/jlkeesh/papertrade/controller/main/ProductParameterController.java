package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.ProductParameterCriteria;
import dev.jlkeesh.papertrade.dto.main.ProductParameterCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductParameterDto;
import dev.jlkeesh.papertrade.dto.main.ProductParameterUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.ProductParameterService;
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
public class ProductParameterController extends AbstractController<ProductParameterService> {
    protected ProductParameterController(ProductParameterService service) {
        super(service);
    }

    @GetMapping(PATH + "/product-parameter/{id}")
    public ResponseEntity<Data<ProductParameterDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/product-parameter")
    public ResponseEntity<Data<List<ProductParameterDto>>> getAll(ProductParameterCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/product-parameter")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody ProductParameterCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/product-parameter/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/product-parameter")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody ProductParameterUpdateDto dto) {
        return service.update(dto);
    }
}

package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.ProductCriteria;
import dev.jlkeesh.papertrade.dto.main.ProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductDto;
import dev.jlkeesh.papertrade.dto.main.ProductUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.ProductService;
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
public class ProductPriceController extends AbstractController<ProductService> {
    protected ProductPriceController(ProductService service) {
        super(service);
    }

    @GetMapping(PATH + "/product-price/{id}")
    public ResponseEntity<Data<ProductDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/product-price")
    public ResponseEntity<Data<List<ProductDto>>> getAll(ProductCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/product-price")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody ProductCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/product-price/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/product-price")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody ProductUpdateDto dto) {
        return service.update(dto);
    }
}

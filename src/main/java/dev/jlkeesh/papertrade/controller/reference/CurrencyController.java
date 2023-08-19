package dev.jlkeesh.papertrade.controller.reference;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.CurrencyCriteria;
import dev.jlkeesh.papertrade.dto.reference.CurrencyCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.reference.CurrencyService;
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
public class CurrencyController extends AbstractController<CurrencyService> {
    protected CurrencyController(CurrencyService service) {
        super(service);
    }

    @GetMapping(PATH + "/currency/{id}")
    public ResponseEntity<Data<CurrencyDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/currency")
    public ResponseEntity<Data<List<CurrencyDto>>> getAll(CurrencyCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/currency")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody CurrencyCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/currency/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/currency")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody CurrencyUpdateDto dto) {
        return service.update(dto);
    }
}

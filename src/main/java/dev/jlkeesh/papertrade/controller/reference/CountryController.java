package dev.jlkeesh.papertrade.controller.reference;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.CountryCriteria;
import dev.jlkeesh.papertrade.dto.reference.CountryCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CountryDto;
import dev.jlkeesh.papertrade.dto.reference.CountryUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.reference.CountryService;
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
public class CountryController extends AbstractController<CountryService> {
    protected CountryController(CountryService service) {
        super(service);
    }

    @GetMapping(PATH + "/country/{id}")
    public ResponseEntity<Data<CountryDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/country")
    public ResponseEntity<Data<List<CountryDto>>> getAll(CountryCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/country")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody CountryCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/country/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/country")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody CountryUpdateDto dto) {
        return service.update(dto);
    }
}

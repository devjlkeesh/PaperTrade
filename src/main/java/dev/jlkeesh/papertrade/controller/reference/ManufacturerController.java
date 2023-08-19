package dev.jlkeesh.papertrade.controller.reference;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.ManufacturerCriteria;
import dev.jlkeesh.papertrade.dto.main.ManufacturerCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.ManufacturerService;
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
public class ManufacturerController extends AbstractController<ManufacturerService> {
    protected ManufacturerController(ManufacturerService service) {
        super(service);
    }

    @GetMapping(PATH + "/manufacturer/{id}")
    public ResponseEntity<Data<ManufacturerDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/manufacturer")
    public ResponseEntity<Data<List<ManufacturerDto>>> getAll(ManufacturerCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/manufacturer")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody ManufacturerCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/manufacturer/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/manufacturer")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody ManufacturerUpdateDto dto) {
        return service.update(dto);
    }
}

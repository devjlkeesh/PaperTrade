package dev.jlkeesh.papertrade.controller.reference;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.ParameterCriteria;
import dev.jlkeesh.papertrade.dto.reference.ParameterCreateDto;
import dev.jlkeesh.papertrade.dto.reference.ParameterDto;
import dev.jlkeesh.papertrade.dto.reference.ParameterUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.reference.ParameterService;
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
public class ParameterController extends AbstractController<ParameterService> {
    protected ParameterController(ParameterService service) {
        super(service);
    }

    @GetMapping(PATH + "/parameter/{id}")
    public ResponseEntity<Data<ParameterDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/parameter")
    public ResponseEntity<Data<List<ParameterDto>>> getAll(ParameterCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/parameter")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody ParameterCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/parameter/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/parameter")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody ParameterUpdateDto dto) {
        return service.update(dto);
    }
}

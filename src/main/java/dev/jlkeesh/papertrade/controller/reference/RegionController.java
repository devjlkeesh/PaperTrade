package dev.jlkeesh.papertrade.controller.reference;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.RegionCriteria;
import dev.jlkeesh.papertrade.dto.reference.RegionCreateDto;
import dev.jlkeesh.papertrade.dto.reference.RegionDto;
import dev.jlkeesh.papertrade.dto.reference.RegionUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.reference.RegionService;
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
public class RegionController extends AbstractController<RegionService> {
    protected RegionController(RegionService service) {
        super(service);
    }

    @GetMapping(PATH + "/region/{id}")
    public ResponseEntity<Data<RegionDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/region")
    public ResponseEntity<Data<List<RegionDto>>> getAll(RegionCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/region")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody RegionCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/region/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/region")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody RegionUpdateDto dto) {
        return service.update(dto);
    }
}

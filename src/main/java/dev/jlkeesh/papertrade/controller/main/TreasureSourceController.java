package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.TreasureSourceCriteria;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceDto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.TreasureSourceService;
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
public class TreasureSourceController extends AbstractController<TreasureSourceService> {
    protected TreasureSourceController(TreasureSourceService service) {
        super(service);
    }

    @GetMapping(PATH + "/treasure-source/{id}")
    public ResponseEntity<Data<TreasureSourceDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/treasure-source")
    public ResponseEntity<Data<List<TreasureSourceDto>>> getAll(TreasureSourceCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/treasure-source")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody TreasureSourceCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/treasure-source/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/treasure-source")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody TreasureSourceUpdateDto dto) {
        return service.update(dto);
    }
}

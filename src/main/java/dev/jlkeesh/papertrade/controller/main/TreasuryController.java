package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.TreasuryCriteria;
import dev.jlkeesh.papertrade.dto.main.TreasuryCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasuryDto;
import dev.jlkeesh.papertrade.dto.main.TreasuryUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.TreasuryService;
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
public class TreasuryController extends AbstractController<TreasuryService> {

    protected TreasuryController(TreasuryService service) {
        super(service);
    }

    @GetMapping(PATH + "/treasury/{id}")
    public ResponseEntity<Data<TreasuryDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/treasury")
    public ResponseEntity<Data<List<TreasuryDto>>> getAll(TreasuryCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/treasury")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody TreasuryCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/treasury/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping(PATH + "/treasury")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody TreasuryUpdateDto dto) {
        return service.update(dto);
    }
}

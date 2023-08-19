package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.TreasureReconciliationCriteria;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.TreasureReconciliationService;
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
public class TreasureReconciliationController extends AbstractController<TreasureReconciliationService> {
    protected TreasureReconciliationController(TreasureReconciliationService service) {
        super(service);
    }

    @GetMapping(PATH + "/treasure-reconciliation/{id}")
    public ResponseEntity<Data<TreasureReconciliationDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/treasure-reconciliation")
    public ResponseEntity<Data<List<TreasureReconciliationDto>>> getAll(TreasureReconciliationCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/treasure-reconciliation")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody TreasureReconciliationCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/treasure-reconciliation/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/treasure-reconciliation")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody TreasureReconciliationUpdateDto dto) {
        return service.update(dto);
    }
}

package dev.jlkeesh.papertrade.controller.reference;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.TradeStatusCriteria;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusCreateDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.reference.TradeStatusService;
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
public class TradeStatusController extends AbstractController<TradeStatusService> {
    protected TradeStatusController(TradeStatusService service) {
        super(service);
    }

    @GetMapping(PATH + "/trade-status/{id}")
    public ResponseEntity<Data<TradeStatusDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/trade-status")
    public ResponseEntity<Data<List<TradeStatusDto>>> getAll(TradeStatusCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/trade-status")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody TradeStatusCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/trade-status/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/trade-status")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody TradeStatusUpdateDto dto) {
        return service.update(dto);
    }
}

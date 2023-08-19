package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.TradeCriteria;
import dev.jlkeesh.papertrade.dto.main.TradeCreateDto;
import dev.jlkeesh.papertrade.dto.main.TradeDto;
import dev.jlkeesh.papertrade.dto.main.TradeUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.TradeService;
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
public class TradeController extends AbstractController<TradeService> {
    protected TradeController(TradeService service) {
        super(service);
    }

    @GetMapping(PATH + "/trade/{id}")
    public ResponseEntity<Data<TradeDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/trade")
    public ResponseEntity<Data<List<TradeDto>>> getAll(TradeCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/trade")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody TradeCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/trade/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/trade")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody TradeUpdateDto dto) {
        return service.update(dto);
    }
}

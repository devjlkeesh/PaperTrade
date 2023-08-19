package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.TradeProductCriteria;
import dev.jlkeesh.papertrade.dto.main.TradeProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.TradeProductDto;
import dev.jlkeesh.papertrade.dto.main.TradeProductUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.TradeProductService;
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
public class TradeProductController extends AbstractController<TradeProductService> {
    protected TradeProductController(TradeProductService service) {
        super(service);
    }

    @GetMapping(PATH + "/trade-product/{id}")
    public ResponseEntity<Data<TradeProductDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/trade-product")
    public ResponseEntity<Data<List<TradeProductDto>>> getAll(TradeProductCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/trade-product")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody TradeProductCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/trade-product/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/trade-product")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody TradeProductUpdateDto dto) {
        return service.update(dto);
    }
}

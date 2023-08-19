package dev.jlkeesh.papertrade.controller.main;

import dev.jlkeesh.papertrade.controller.AbstractController;
import dev.jlkeesh.papertrade.criteria.ConsigneeCriteria;
import dev.jlkeesh.papertrade.dto.main.ConsigneeCreateDto;
import dev.jlkeesh.papertrade.dto.main.ConsigneeDto;
import dev.jlkeesh.papertrade.dto.main.ConsigneeUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.service.main.ConsigneeService;
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
public class ConsigneeController extends AbstractController<ConsigneeService> {
    protected ConsigneeController(ConsigneeService service) {
        super(service);
    }

    @GetMapping(PATH + "/consignee/{id}")
    public ResponseEntity<Data<ConsigneeDto>> get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping(PATH + "/consignee")
    public ResponseEntity<Data<List<ConsigneeDto>>> getAll(ConsigneeCriteria criteria) {
        return service.getAll(criteria);
    }

    @PostMapping(PATH + "/consignee")
    public ResponseEntity<Data<Long>> create(@NonNull @Valid @RequestBody ConsigneeCreateDto dto) {
        return service.create(dto);
    }

    @DeleteMapping(PATH + "/consignee/{id}")
    public ResponseEntity<Data<Boolean>> delete(@PathVariable Long id) {
        return service.delete(id);
    }


    @PutMapping(PATH + "/consignee")
    public ResponseEntity<Data<Boolean>> update(@NonNull @Valid @RequestBody ConsigneeUpdateDto dto) {
        return service.update(dto);
    }
}

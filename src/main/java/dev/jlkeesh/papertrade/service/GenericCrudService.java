package dev.jlkeesh.papertrade.service;

import dev.jlkeesh.papertrade.criteria.GenericCriteria;
import dev.jlkeesh.papertrade.dto.Dto;
import dev.jlkeesh.papertrade.dto.response.Data;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;


/**
 * @author : Elmurodov Javohir
 * @description :
 * @time : 31/05/23/18:10
 */

public interface GenericCrudService<
        D extends Dto,
        CD extends Dto,
        UD extends Dto,
        C extends GenericCriteria,
        ID extends Serializable> extends GenericService {
    ResponseEntity<Data<List<D>>> getAll(@NonNull C criteria);

    ResponseEntity<Data<D>> get(@NonNull ID id);

    ResponseEntity<Data<ID>> create(@NonNull CD dto);

    ResponseEntity<Data<Boolean>> delete(@NonNull ID id);

    ResponseEntity<Data<Boolean>> update(@NonNull UD dto);
}

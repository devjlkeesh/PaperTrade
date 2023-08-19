package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ConsigneeCriteria;
import dev.jlkeesh.papertrade.domains.main.Consignee;
import dev.jlkeesh.papertrade.dto.main.ConsigneeCreateDto;
import dev.jlkeesh.papertrade.dto.main.ConsigneeDto;
import dev.jlkeesh.papertrade.dto.main.ConsigneeUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.State;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.ConsigneeMapper;
import dev.jlkeesh.papertrade.repository.main.ConsigneeRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:26
 */

@Service
public class ConsigneeServiceImpl extends AbstractService<ConsigneeRepository, ConsigneeMapper> implements ConsigneeService {
    protected ConsigneeServiceImpl(ConsigneeRepository repository, ConsigneeMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<ConsigneeDto>>> getAll(@NonNull ConsigneeCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Consignee> consigneeList = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(consigneeList), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ConsigneeDto>> get(@NonNull Long id) {
        Consignee consignee = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(consignee)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ConsigneeCreateDto dto) {
        repository.find(ConsigneeCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(consignee -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Consignee consignee = mapper.fromCreateDto(dto);
        consignee.setState(State.ACTIVE);
        repository.save(consignee);
        return new ResponseEntity<>(new Data<>(consignee.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ConsigneeUpdateDto dto) {
        Consignee consignee = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, consignee));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

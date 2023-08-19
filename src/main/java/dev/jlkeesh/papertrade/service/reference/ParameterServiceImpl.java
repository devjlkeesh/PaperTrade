package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.ParameterCriteria;
import dev.jlkeesh.papertrade.domains.reference.Parameter;
import dev.jlkeesh.papertrade.dto.reference.ParameterCreateDto;
import dev.jlkeesh.papertrade.dto.reference.ParameterDto;
import dev.jlkeesh.papertrade.dto.reference.ParameterUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.reference.ParameterMapper;
import dev.jlkeesh.papertrade.repository.reference.ParameterRepository;
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
public class ParameterServiceImpl extends AbstractService<ParameterRepository, ParameterMapper> implements ParameterService {
    protected ParameterServiceImpl(ParameterRepository repository, ParameterMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<ParameterDto>>> getAll(@NonNull ParameterCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Parameter> parameters = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(parameters), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ParameterDto>> get(@NonNull Long id) {
        Parameter parameter = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(parameter)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ParameterCreateDto dto) {
        repository.find(ParameterCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(parameter -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Parameter parameter = mapper.fromCreateDto(dto);
        repository.save(parameter);
        return new ResponseEntity<>(new Data<>(parameter.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ParameterUpdateDto dto) {
        Parameter parameter = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, parameter));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

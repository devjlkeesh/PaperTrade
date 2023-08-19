package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TreasureSourceCriteria;
import dev.jlkeesh.papertrade.domains.main.TreasureSource;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceDto;
import dev.jlkeesh.papertrade.dto.main.TreasureSourceUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.State;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.TreasureSourceMapper;
import dev.jlkeesh.papertrade.repository.main.TreasureSourceRepository;
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
public class TreasureSourceServiceImpl extends AbstractService<TreasureSourceRepository, TreasureSourceMapper> implements TreasureSourceService {
    protected TreasureSourceServiceImpl(TreasureSourceRepository repository, TreasureSourceMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<TreasureSourceDto>>> getAll(@NonNull TreasureSourceCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<TreasureSource> treasureSources = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(treasureSources), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TreasureSourceDto>> get(@NonNull Long id) {
        TreasureSource treasureSource = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(treasureSource)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull TreasureSourceCreateDto dto) {
        repository.find(TreasureSourceCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(treasureSource -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        TreasureSource treasureSource = mapper.fromCreateDto(dto);
        treasureSource.setState(State.ACTIVE);
        repository.save(treasureSource);
        return new ResponseEntity<>(new Data<>(treasureSource.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull TreasureSourceUpdateDto dto) {
        TreasureSource treasureSource = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, treasureSource));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

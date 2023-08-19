package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.TradeStatusCriteria;
import dev.jlkeesh.papertrade.domains.reference.TradeStatus;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusCreateDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusDto;
import dev.jlkeesh.papertrade.dto.reference.TradeStatusUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.reference.TradeStatusMapper;
import dev.jlkeesh.papertrade.repository.reference.TradeStatusRepository;
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
public class TradeStatusServiceImpl extends AbstractService<TradeStatusRepository, TradeStatusMapper> implements TradeStatusService {
    protected TradeStatusServiceImpl(TradeStatusRepository repository, TradeStatusMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<TradeStatusDto>>> getAll(@NonNull TradeStatusCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<TradeStatus> countries = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(countries), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TradeStatusDto>> get(@NonNull Long id) {
        TradeStatus country = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(country)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull TradeStatusCreateDto dto) {
        repository.find(TradeStatusCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(country -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        TradeStatus country = mapper.fromCreateDto(dto);
        repository.save(country);
        return new ResponseEntity<>(new Data<>(country.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull TradeStatusUpdateDto dto) {
        TradeStatus country = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, country));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

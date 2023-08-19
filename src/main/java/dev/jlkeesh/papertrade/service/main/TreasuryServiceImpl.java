package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TreasuryCriteria;
import dev.jlkeesh.papertrade.domains.main.Treasury;
import dev.jlkeesh.papertrade.dto.main.TreasuryCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasuryDto;
import dev.jlkeesh.papertrade.dto.main.TreasuryUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.TreasuryMapper;
import dev.jlkeesh.papertrade.repository.main.TreasuryRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:52
 */

@Service
public class TreasuryServiceImpl extends AbstractService<TreasuryRepository, TreasuryMapper> implements TreasuryService {

    protected TreasuryServiceImpl(TreasuryRepository repository, TreasuryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<TreasuryDto>>> getAll(@NonNull TreasuryCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Treasury> treasuries = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(treasuries), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TreasuryDto>> get(@NonNull Long id) {
        Treasury treasury = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(treasury)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull TreasuryCreateDto dto) {
        repository.find(TreasuryCriteria
                        .childBuilder()
                        .treasureSourceId(dto.treasureSourceId())
                        .inCustomerPaymentId(dto.inCustomerPaymentId())
                        .outExpenseId(dto.outExpenseId())
                        .build())
                .ifPresent(manufacturer -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });


        Treasury treasury = mapper.fromCreateDto(dto);
        repository.save(treasury);
        return new ResponseEntity<>(new Data<>(treasury.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull TreasuryUpdateDto dto) {
        Treasury treasury = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, treasury));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

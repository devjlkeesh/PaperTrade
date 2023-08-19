package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TreasureReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.TreasureReconciliation;
import dev.jlkeesh.papertrade.domains.main.TreasureSource;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationDto;
import dev.jlkeesh.papertrade.dto.main.TreasureReconciliationUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.TreasureReconciliationMapper;
import dev.jlkeesh.papertrade.repository.main.TreasureReconciliationRepository;
import dev.jlkeesh.papertrade.repository.main.TreasureSourceRepositoryImpl;
import dev.jlkeesh.papertrade.repository.reference.CurrencyRepositoryImpl;
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
public class TreasureReconciliationServiceImpl extends AbstractService<TreasureReconciliationRepository, TreasureReconciliationMapper> implements TreasureReconciliationService {
    private final CurrencyRepositoryImpl currencyRepository;
    private final TreasureSourceRepositoryImpl treasureSourceRepository;

    protected TreasureReconciliationServiceImpl(TreasureReconciliationRepository repository, TreasureReconciliationMapper mapper, CurrencyRepositoryImpl currencyRepository, TreasureSourceRepositoryImpl treasureSourceRepository) {
        super(repository, mapper);
        this.currencyRepository = currencyRepository;
        this.treasureSourceRepository = treasureSourceRepository;
    }

    @Override
    public ResponseEntity<Data<List<TreasureReconciliationDto>>> getAll(@NonNull TreasureReconciliationCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<TreasureReconciliation> treasureReconciliations = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(treasureReconciliations), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TreasureReconciliationDto>> get(@NonNull Long id) {
        TreasureReconciliation treasureReconciliation = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(treasureReconciliation)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull TreasureReconciliationCreateDto dto) {
        // TODO: 19/08/23 need to check for begin end date or not need to ask ?
        TreasureReconciliation treasureReconciliation = mapper.fromCreateDto(dto);
        Currency currency = currencyRepository.find(dto.getCurrencyId()).orElseThrow(ResourceNotFoundException::new);
        TreasureSource treasureSource = treasureSourceRepository.find(dto.getTreasureSourceId()).orElseThrow(ResourceNotFoundException::new);
        treasureReconciliation.setCurrency(currency);
        treasureReconciliation.setTreasureSource(treasureSource);
        repository.save(treasureReconciliation);
        return new ResponseEntity<>(new Data<>(treasureReconciliation.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull TreasureReconciliationUpdateDto dto) {
        TreasureReconciliation treasureReconciliation = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        treasureReconciliation = mapper.partialUpdate(dto, treasureReconciliation);
        if (dto.getCurrencyId() != null) {
            Currency currency = currencyRepository.find(dto.getCurrencyId()).orElseThrow(ResourceNotFoundException::new);
            treasureReconciliation.setCurrency(currency);
        }
        if (dto.getTreasureSourceId() != null) {
            TreasureSource treasureSource = treasureSourceRepository.find(dto.getTreasureSourceId()).orElseThrow(ResourceNotFoundException::new);
            treasureReconciliation.setTreasureSource(treasureSource);
        }
        repository.save(treasureReconciliation);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

}

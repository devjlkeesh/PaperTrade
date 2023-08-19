package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.CurrencyCriteria;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.dto.reference.CurrencyCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.reference.CurrencyMapper;
import dev.jlkeesh.papertrade.repository.reference.CurrencyRepository;
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
public class CurrencyServiceImpl extends AbstractService<CurrencyRepository, CurrencyMapper> implements CurrencyService {
    protected CurrencyServiceImpl(CurrencyRepository repository, CurrencyMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<CurrencyDto>>> getAll(@NonNull CurrencyCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Currency> countries = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(countries), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CurrencyDto>> get(@NonNull Long id) {
        Currency country = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(country)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull CurrencyCreateDto dto) {
        repository.find(CurrencyCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(country -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Currency country = mapper.fromCreateDto(dto);
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
    public ResponseEntity<Data<Boolean>> update(@NonNull CurrencyUpdateDto dto) {
        Currency country = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, country));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

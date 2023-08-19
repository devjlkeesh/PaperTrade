package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.CountryCriteria;
import dev.jlkeesh.papertrade.domains.reference.Country;
import dev.jlkeesh.papertrade.dto.reference.CountryCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CountryDto;
import dev.jlkeesh.papertrade.dto.reference.CountryUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.reference.CountryMapper;
import dev.jlkeesh.papertrade.repository.reference.CountryRepository;
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
public class CountryServiceImpl extends AbstractService<CountryRepository, CountryMapper> implements CountryService {
    protected CountryServiceImpl(CountryRepository repository, CountryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<CountryDto>>> getAll(@NonNull CountryCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Country> countries = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(countries), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CountryDto>> get(@NonNull Long id) {
        Country country = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(country)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull CountryCreateDto dto) {
        repository.find(CountryCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(country -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Country country = mapper.fromCreateDto(dto);
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
    public ResponseEntity<Data<Boolean>> update(@NonNull CountryUpdateDto dto) {
        Country country = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, country));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.CountryCriteria;
import dev.jlkeesh.papertrade.criteria.ManufacturerCriteria;
import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.domains.reference.Country;
import dev.jlkeesh.papertrade.dto.main.ManufacturerCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.enums.State;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.ManufacturerMapper;
import dev.jlkeesh.papertrade.repository.main.ManufacturerRepository;
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
public class ManufacturerServiceImpl extends AbstractService<ManufacturerRepository, ManufacturerMapper> implements ManufacturerService {
    private final CountryRepository countryRepository;

    protected ManufacturerServiceImpl(ManufacturerRepository repository, ManufacturerMapper mapper, CountryRepository countryRepository) {
        super(repository, mapper);
        this.countryRepository = countryRepository;
    }

    @Override
    public ResponseEntity<Data<List<ManufacturerDto>>> getAll(@NonNull ManufacturerCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Manufacturer> manufacturerList = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(manufacturerList), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ManufacturerDto>> get(@NonNull Long id) {
        Manufacturer manufacturer = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(manufacturer)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ManufacturerCreateDto dto) {
        repository.find(ManufacturerCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(manufacturer -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });

        Country country = countryRepository.find(dto.countryId()).orElseThrow(ResourceNotFoundException::new);

        Manufacturer manufacturer = mapper.fromCreateDto(dto);
        manufacturer.setState(State.ACTIVE);
        manufacturer.setCountry(country);
        repository.save(manufacturer);
        return new ResponseEntity<>(new Data<>(manufacturer.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ManufacturerUpdateDto dto) {
        Manufacturer manufacturer = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        manufacturer = mapper.partialUpdate(dto, manufacturer);
        if (dto.countryId() != null) {
            Country country = countryRepository.find(dto.countryId()).orElseThrow(ResourceNotFoundException::new);
            manufacturer.setCountry(country);
        }
        repository.save(manufacturer);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

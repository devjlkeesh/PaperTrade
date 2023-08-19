package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.RegionCriteria;
import dev.jlkeesh.papertrade.domains.reference.Region;
import dev.jlkeesh.papertrade.dto.reference.RegionCreateDto;
import dev.jlkeesh.papertrade.dto.reference.RegionDto;
import dev.jlkeesh.papertrade.dto.reference.RegionUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.reference.RegionMapper;
import dev.jlkeesh.papertrade.repository.reference.RegionRepository;
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
public class RegionServiceImpl extends AbstractService<RegionRepository, RegionMapper> implements RegionService {
    protected RegionServiceImpl(RegionRepository repository, RegionMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<RegionDto>>> getAll(@NonNull RegionCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Region> countries = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(countries), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<RegionDto>> get(@NonNull Long id) {
        Region country = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(country)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull RegionCreateDto dto) {
        repository.find(RegionCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(country -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Region country = mapper.fromCreateDto(dto);
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
    public ResponseEntity<Data<Boolean>> update(@NonNull RegionUpdateDto dto) {
        Region country = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, country));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

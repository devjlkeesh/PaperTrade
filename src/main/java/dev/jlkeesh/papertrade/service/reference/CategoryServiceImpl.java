package dev.jlkeesh.papertrade.service.reference;

import dev.jlkeesh.papertrade.criteria.CategoryCriteria;
import dev.jlkeesh.papertrade.domains.reference.Category;
import dev.jlkeesh.papertrade.dto.reference.CategoryCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CategoryDto;
import dev.jlkeesh.papertrade.dto.reference.CategoryUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.reference.CategoryMapper;
import dev.jlkeesh.papertrade.repository.reference.CategoryRepository;
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
public class CategoryServiceImpl extends AbstractService<CategoryRepository, CategoryMapper> implements CategoryService {
    protected CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public ResponseEntity<Data<List<CategoryDto>>> getAll(@NonNull CategoryCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Category> categories = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(categories), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<CategoryDto>> get(@NonNull Long id) {
        Category category = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(category)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull CategoryCreateDto dto) {
        repository.find(CategoryCriteria.childBuilder().name(dto.name()).build())
                .ifPresent(category -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Category category = mapper.fromCreateDto(dto);
        repository.save(category);
        return new ResponseEntity<>(new Data<>(category.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull CategoryUpdateDto dto) {
        Category category = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, category));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ProductCriteria;
import dev.jlkeesh.papertrade.domains.main.Product;
import dev.jlkeesh.papertrade.domains.reference.Category;
import dev.jlkeesh.papertrade.dto.main.ProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductDto;
import dev.jlkeesh.papertrade.dto.main.ProductUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.ProductMapper;
import dev.jlkeesh.papertrade.repository.main.ProductRepository;
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
public class ProductServiceImpl extends AbstractService<ProductRepository, ProductMapper> implements ProductService {
    private final CategoryRepository categoryRepository;

    protected ProductServiceImpl(ProductRepository repository, ProductMapper mapper, CategoryRepository categoryRepository) {
        super(repository, mapper);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<Data<List<ProductDto>>> getAll(@NonNull ProductCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Product> products = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(products), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ProductDto>> get(@NonNull Long id) {
        Product product = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(product)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ProductCreateDto dto) {
        repository.find(ProductCriteria.childBuilder().name(dto.name()).categoryId(dto.categoryId()).build())
                .ifPresent(product -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Product product = mapper.fromCreateDto(dto);
        Category category = categoryRepository.find(dto.categoryId()).orElseThrow(ResourceNotFoundException::new);
        product.setCategory(category);
        repository.save(product);
        return new ResponseEntity<>(new Data<>(product.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ProductUpdateDto dto) {
        Product product = repository.find(dto.id()).orElseThrow(ResourceNotFoundException::new);
        product = mapper.partialUpdate(dto, product);
        if (dto.categoryId() != null) {
            Category category = categoryRepository.find(dto.categoryId()).orElseThrow(ResourceNotFoundException::new);
            product.setCategory(category);
        }
        repository.save(product);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ProductParameterCriteria;
import dev.jlkeesh.papertrade.domains.main.Product;
import dev.jlkeesh.papertrade.domains.main.ProductParameter;
import dev.jlkeesh.papertrade.domains.reference.Parameter;
import dev.jlkeesh.papertrade.dto.main.ProductParameterCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductParameterDto;
import dev.jlkeesh.papertrade.dto.main.ProductParameterUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.ProductParameterMapper;
import dev.jlkeesh.papertrade.repository.main.ProductParameterRepository;
import dev.jlkeesh.papertrade.repository.main.ProductRepository;
import dev.jlkeesh.papertrade.repository.reference.ParameterRepository;
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
public class ProductParameterServiceImpl extends AbstractService<ProductParameterRepository, ProductParameterMapper> implements ProductParameterService {
    private final ProductRepository productRepository;
    private final ParameterRepository parameterRepository;

    protected ProductParameterServiceImpl(ProductParameterRepository repository, ProductParameterMapper mapper, ProductRepository productRepository, ParameterRepository parameterRepository) {
        super(repository, mapper);
        this.productRepository = productRepository;
        this.parameterRepository = parameterRepository;
    }

    @Override
    public ResponseEntity<Data<List<ProductParameterDto>>> getAll(@NonNull ProductParameterCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<ProductParameter> products = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(products), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ProductParameterDto>> get(@NonNull Long id) {
        ProductParameter product = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(product)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ProductParameterCreateDto dto) {
        repository.find(ProductParameterCriteria.childBuilder().productId(dto.getProductId()).productId(dto.getProductId()).parameterId(dto.getParameterId()).build())
                .ifPresent(product -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Product product = productRepository.find(dto.getProductId()).orElseThrow(ResourceNotFoundException::new);
        Parameter parameter = parameterRepository.find(dto.getParameterId()).orElseThrow(ResourceNotFoundException::new);
        ProductParameter productPrice = mapper.fromCreateDto(dto);
        productPrice.setProduct(product);
        productPrice.setProduct(product);
        productPrice.setParameter(parameter);
        repository.save(productPrice);
        return new ResponseEntity<>(new Data<>(product.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ProductParameterUpdateDto dto) {
        ProductParameter product = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, product));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

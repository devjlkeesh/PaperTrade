package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ProductPriceCriteria;
import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.domains.main.Product;
import dev.jlkeesh.papertrade.domains.main.ProductPrice;
import dev.jlkeesh.papertrade.dto.main.ProductPriceCreateDto;
import dev.jlkeesh.papertrade.dto.main.ProductPriceDto;
import dev.jlkeesh.papertrade.dto.main.ProductPriceUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.ProductPriceMapper;
import dev.jlkeesh.papertrade.repository.main.ManufacturerRepository;
import dev.jlkeesh.papertrade.repository.main.ProductPriceRepository;
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
public class ProductPriceServiceImpl extends AbstractService<ProductPriceRepository, ProductPriceMapper> implements ProductPriceService {
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;

    protected ProductPriceServiceImpl(ProductPriceRepository repository, ProductPriceMapper mapper, CategoryRepository categoryRepository, ManufacturerRepository manufacturerRepository, ProductRepository productRepository) {
        super(repository, mapper);
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Data<List<ProductPriceDto>>> getAll(@NonNull ProductPriceCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<ProductPrice> products = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(products), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ProductPriceDto>> get(@NonNull Long id) {
        ProductPrice product = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(product)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ProductPriceCreateDto dto) {
        repository.find(ProductPriceCriteria.childBuilder().productId(dto.getProductId()).manufacturerId(dto.getManufacturerId()).build())
                .ifPresent(product -> {
                    throw new BadRequestException(ErrorCode.ALREADY_CREATED);
                });
        Manufacturer manufacturer = manufacturerRepository.find(dto.getManufacturerId()).orElseThrow(ResourceNotFoundException::new);
        Product product = productRepository.find(dto.getProductId()).orElseThrow(ResourceNotFoundException::new);
        ProductPrice productPrice = mapper.fromCreateDto(dto);
        productPrice.setProduct(product);
        productPrice.setManufacturer(manufacturer);
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
    public ResponseEntity<Data<Boolean>> update(@NonNull ProductPriceUpdateDto dto) {
        ProductPrice product = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, product));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

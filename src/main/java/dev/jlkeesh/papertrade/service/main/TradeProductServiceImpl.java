package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TradeProductCriteria;
import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.domains.main.Product;
import dev.jlkeesh.papertrade.domains.main.Trade;
import dev.jlkeesh.papertrade.domains.main.TradeProduct;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.dto.main.TradeProductCreateDto;
import dev.jlkeesh.papertrade.dto.main.TradeProductDto;
import dev.jlkeesh.papertrade.dto.main.TradeProductUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.enums.ErrorCode;
import dev.jlkeesh.papertrade.exceptions.BadRequestException;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.TradeProductMapper;
import dev.jlkeesh.papertrade.repository.main.ManufacturerRepository;
import dev.jlkeesh.papertrade.repository.main.ProductRepository;
import dev.jlkeesh.papertrade.repository.main.TradeProductRepository;
import dev.jlkeesh.papertrade.repository.main.TradeRepository;
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
public class TradeProductServiceImpl extends AbstractService<TradeProductRepository, TradeProductMapper> implements TradeProductService {
    private final TradeRepository tradeRepository;
    private final CurrencyRepository currencyRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;

    protected TradeProductServiceImpl(TradeProductRepository repository, TradeProductMapper mapper, TradeRepository tradeRepository, CurrencyRepository currencyRepository, ManufacturerRepository manufacturerRepository, ProductRepository productRepository) {
        super(repository, mapper);
        this.tradeRepository = tradeRepository;
        this.currencyRepository = currencyRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Data<List<TradeProductDto>>> getAll(@NonNull TradeProductCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<TradeProduct> tradeProducts = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(tradeProducts), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TradeProductDto>> get(@NonNull Long id) {
        TradeProduct tradeProduct = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(tradeProduct)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull TradeProductCreateDto dto) {
        repository.find(TradeProductCriteria.childBuilder().barCode(dto.getBarCode()).build())
                .ifPresent(tradeProduct -> {
                    throw new BadRequestException(ErrorCode.BAR_CODE_ALREADY_CREATED);
                });
        Product product = productRepository.find(dto.getProductId()).orElseThrow(ResourceNotFoundException::new);
        Manufacturer manufacturer = manufacturerRepository.find(dto.getManufacturerId()).orElseThrow(ResourceNotFoundException::new);
        Trade trade = tradeRepository.find(dto.getTradeId()).orElseThrow(ResourceNotFoundException::new);
        Currency currency = currencyRepository.find(dto.getCurrencyId()).orElseThrow(ResourceNotFoundException::new);
        TradeProduct tradeProduct = mapper.fromCreateDto(dto);
        tradeProduct.setProduct(product);
        tradeProduct.setManufacturer(manufacturer);
        tradeProduct.setTrade(trade);
        tradeProduct.setCurrency(currency);
        repository.save(tradeProduct);
        return new ResponseEntity<>(new Data<>(tradeProduct.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull TradeProductUpdateDto dto) {
        TradeProduct tradeProduct = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, tradeProduct));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

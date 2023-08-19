package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.TradeCriteria;
import dev.jlkeesh.papertrade.domains.main.Customer;
import dev.jlkeesh.papertrade.domains.main.Trade;
import dev.jlkeesh.papertrade.domains.reference.TradeStatus;
import dev.jlkeesh.papertrade.dto.main.TradeCreateDto;
import dev.jlkeesh.papertrade.dto.main.TradeDto;
import dev.jlkeesh.papertrade.dto.main.TradeUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.TradeMapper;
import dev.jlkeesh.papertrade.repository.main.CustomerRepository;
import dev.jlkeesh.papertrade.repository.main.TradeRepository;
import dev.jlkeesh.papertrade.repository.reference.TradeStatusRepository;
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
public class TradeServiceImpl extends AbstractService<TradeRepository, TradeMapper> implements TradeService {
    private final TradeStatusRepository tradeStatusRepository;
    private final CustomerRepository customerRepository;
    protected TradeServiceImpl(TradeRepository repository, TradeMapper mapper, TradeStatusRepository tradeStatusRepository, CustomerRepository customerRepository) {
        super(repository, mapper);
        this.tradeStatusRepository = tradeStatusRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<Data<List<TradeDto>>> getAll(@NonNull TradeCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<Trade> trades = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(trades), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<TradeDto>> get(@NonNull Long id) {
        Trade trade = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(trade)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull TradeCreateDto dto) {
        Customer customer = customerRepository.find(dto.getCustomerId()).orElseThrow(ResourceNotFoundException::new);
        TradeStatus tradeStatus = tradeStatusRepository.find(dto.getTradeStatusId()).orElseThrow(ResourceNotFoundException::new);
        Trade trade = mapper.fromCreateDto(dto);
        trade.setTradeStatus(tradeStatus);
        trade.setCustomer(customer);
        repository.save(trade);
        return new ResponseEntity<>(new Data<>(trade.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull TradeUpdateDto dto) {
        Trade trade = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, trade));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

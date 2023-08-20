package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentCriteria;
import dev.jlkeesh.papertrade.domains.main.Consignee;
import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPayment;
import dev.jlkeesh.papertrade.domains.main.OrderWagon;
import dev.jlkeesh.papertrade.domains.reference.Country;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentDto;
import dev.jlkeesh.papertrade.mapper.main.ManufacturerPaymentMapper;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentUpdateDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.repository.main.ConsigneeRepository;
import dev.jlkeesh.papertrade.repository.main.ManufacturerPaymentRepository;
import dev.jlkeesh.papertrade.repository.main.ManufacturerRepository;
import dev.jlkeesh.papertrade.repository.main.OrderWagonRepository;
import dev.jlkeesh.papertrade.repository.reference.CountryRepository;
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
public class ManufacturerPaymentServiceImpl extends AbstractService<ManufacturerPaymentRepository, ManufacturerPaymentMapper> implements ManufacturerPaymentService {

    private final CountryRepository countryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final OrderWagonRepository orderWagonRepository;
    private final ConsigneeRepository consigneeRepository;
    private final CurrencyRepository currencyRepository;

    protected ManufacturerPaymentServiceImpl(ManufacturerPaymentRepository repository, ManufacturerPaymentMapper mapper, CountryRepository countryRepository, ManufacturerRepository manufacturerRepository, OrderWagonRepository orderWagonRepository, ConsigneeRepository consigneeRepository, CurrencyRepository currencyRepository) {
        super(repository, mapper);
        this.countryRepository = countryRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.orderWagonRepository = orderWagonRepository;
        this.consigneeRepository = consigneeRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public ResponseEntity<Data<List<ManufacturerPaymentDto>>> getAll(@NonNull ManufacturerPaymentCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<ManufacturerPayment> manufacturerPayments = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(manufacturerPayments), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ManufacturerPaymentDto>> get(@NonNull Long id) {
        ManufacturerPayment manufacturerPayment = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(manufacturerPayment)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ManufacturerPaymentCreateDto dto) {
        // TODO: 20/08/23 Any check ?
        Country country = countryRepository.find(dto.getCountryId()).orElseThrow(ResourceNotFoundException::new);
        Manufacturer manufacturer = manufacturerRepository.find(dto.getManufacturerId()).orElseThrow(ResourceNotFoundException::new);
        Consignee consignee = consigneeRepository.find(dto.getConsigneeId()).orElseThrow(ResourceNotFoundException::new);
        OrderWagon orderWagon = orderWagonRepository.find(dto.getOrderWagonId()).orElseThrow(ResourceNotFoundException::new);
        Currency currency = currencyRepository.find(dto.getCurrencyId()).orElseThrow(ResourceNotFoundException::new);
        ManufacturerPayment manufacturerPayment = mapper.fromCreateDto(dto);
        manufacturerPayment.setCountry(country);
        manufacturerPayment.setManufacturer(manufacturer);
        manufacturerPayment.setConsignee(consignee);
        manufacturerPayment.setOrderWagon(orderWagon);
        manufacturerPayment.setCurrency(currency);
        repository.save(manufacturerPayment);
        return new ResponseEntity<>(new Data<>(manufacturerPayment.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ManufacturerPaymentUpdateDto dto) {
        ManufacturerPayment manufacturerPayment = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        manufacturerPayment = mapper.partialUpdate(dto, manufacturerPayment);
        setCountry(dto.getCountryId(), manufacturerPayment);
        setManufacturer(dto.getManufacturerId(), manufacturerPayment);
        setConsignee(dto.getConsigneeId(), manufacturerPayment);
        setOrderWagon(dto.getOrderWagonId(), manufacturerPayment);
        setCurrency(dto.getCurrencyId(), manufacturerPayment);
        repository.save(manufacturerPayment);
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    private void setCurrency(Long id, ManufacturerPayment manufacturerPayment) {
        if (id != null) {
            Currency currency = currencyRepository.find(id).orElseThrow(ResourceNotFoundException::new);
            manufacturerPayment.setCurrency(currency);
        }
    }

    private void setOrderWagon(Long id, ManufacturerPayment manufacturerPayment) {
        if (id != null) {
            OrderWagon orderWagon = orderWagonRepository.find(id).orElseThrow(ResourceNotFoundException::new);
            manufacturerPayment.setOrderWagon(orderWagon);
        }
    }

    private void setConsignee(Long id, ManufacturerPayment manufacturerPayment) {
        if (id != null) {
            Consignee consignee = consigneeRepository.find(id).orElseThrow(ResourceNotFoundException::new);
            manufacturerPayment.setConsignee(consignee);
        }
    }

    private void setManufacturer(Long id, ManufacturerPayment manufacturerPayment) {
        if (id != null) {
            Manufacturer manufacturer = manufacturerRepository.find(id).orElseThrow(ResourceNotFoundException::new);
            manufacturerPayment.setManufacturer(manufacturer);
        }
    }

    private void setCountry(Long id, ManufacturerPayment manufacturerPayment) {
        if (id != null) {
            Country country = countryRepository.find(id).orElseThrow(ResourceNotFoundException::new);
            manufacturerPayment.setCountry(country);
        }
    }
}

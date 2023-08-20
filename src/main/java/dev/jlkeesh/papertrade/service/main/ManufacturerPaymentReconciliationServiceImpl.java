package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentReconciliationCriteria;
import dev.jlkeesh.papertrade.domains.main.Consignee;
import dev.jlkeesh.papertrade.domains.main.Manufacturer;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliation;
import dev.jlkeesh.papertrade.domains.main.ManufacturerPaymentsReconciliationUpdateDto;
import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentsReconciliationCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentsReconciliationDto;
import dev.jlkeesh.papertrade.dto.response.Data;
import dev.jlkeesh.papertrade.exceptions.ResourceNotFoundException;
import dev.jlkeesh.papertrade.mapper.main.ManufacturerPaymentReconciliationMapper;
import dev.jlkeesh.papertrade.repository.main.ConsigneeRepository;
import dev.jlkeesh.papertrade.repository.main.ManufacturerPaymentReconciliationRepository;
import dev.jlkeesh.papertrade.repository.main.ManufacturerRepository;
import dev.jlkeesh.papertrade.repository.reference.CurrencyRepository;
import dev.jlkeesh.papertrade.service.AbstractService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

/**
 * @author : Suhrob Karimov
 * @since : 19/08/2023 - 23:52
 */

@Service
public class ManufacturerPaymentReconciliationServiceImpl extends AbstractService<ManufacturerPaymentReconciliationRepository, ManufacturerPaymentReconciliationMapper> implements ManufacturerPaymentReconciliationService {

    private final ManufacturerRepository manufacturerRepository;
    private final ConsigneeRepository consigneeRepository;
    private final CurrencyRepository currencyRepository;


    protected ManufacturerPaymentReconciliationServiceImpl(ManufacturerPaymentReconciliationRepository repository, ManufacturerPaymentReconciliationMapper mapper, ManufacturerRepository manufacturerRepository, ConsigneeRepository consigneeRepository, CurrencyRepository currencyRepository) {
        super(repository, mapper);
        this.manufacturerRepository = manufacturerRepository;
        this.consigneeRepository = consigneeRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public ResponseEntity<Data<List<ManufacturerPaymentsReconciliationDto>>> getAll(@NonNull ManufacturerPaymentReconciliationCriteria criteria) {
        Long totalCount = repository.getTotalCount(criteria);
        List<ManufacturerPaymentsReconciliation> treasuries = repository.findAll(criteria);
        return new ResponseEntity<>(new Data<>(mapper.toDto(treasuries), totalCount), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<ManufacturerPaymentsReconciliationDto>> get(@NonNull Long id) {
        ManufacturerPaymentsReconciliation treasury = repository.find(id).orElseThrow(ResolutionException::new);
        return new ResponseEntity<>(new Data<>(mapper.toDto(treasury)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Long>> create(@NonNull ManufacturerPaymentsReconciliationCreateDto dto) {
        Manufacturer manufacturer = manufacturerRepository.find(dto.getManufacturerId()).orElseThrow(ResourceNotFoundException::new);
        Consignee consignee = consigneeRepository.find(dto.getConsigneeId()).orElseThrow(ResourceNotFoundException::new);
        Currency currency = currencyRepository.find(dto.getCurrencyId()).orElseThrow(ResourceNotFoundException::new);
        ManufacturerPaymentsReconciliation manufacturerPaymentsReconciliation = mapper.fromCreateDto(dto);
        manufacturerPaymentsReconciliation.setManufacturer(manufacturer);
        manufacturerPaymentsReconciliation.setConsignee(consignee);
        manufacturerPaymentsReconciliation.setCurrency(currency);
        repository.save(manufacturerPaymentsReconciliation);
        return new ResponseEntity<>(new Data<>(manufacturerPaymentsReconciliation.getId()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(@NonNull Long id) {
        if (!repository.delete(id))
            throw new ResourceNotFoundException();
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(@NonNull ManufacturerPaymentsReconciliationUpdateDto dto) {
        ManufacturerPaymentsReconciliation treasury = repository.find(dto.getId()).orElseThrow(ResourceNotFoundException::new);
        repository.save(mapper.partialUpdate(dto, treasury));
        return new ResponseEntity<>(new Data<>(true), HttpStatus.OK);
    }
}

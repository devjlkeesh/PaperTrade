package dev.jlkeesh.papertrade.service.main;

import dev.jlkeesh.papertrade.criteria.ManufacturerPaymentCriteria;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentCreateDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentDto;
import dev.jlkeesh.papertrade.dto.main.ManufacturerPaymentUpdateDto;
import dev.jlkeesh.papertrade.service.GenericCrudService;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:25
 */
public interface ManufacturerPaymentService extends GenericCrudService<ManufacturerPaymentDto, ManufacturerPaymentCreateDto, ManufacturerPaymentUpdateDto, ManufacturerPaymentCriteria, Long> {
}

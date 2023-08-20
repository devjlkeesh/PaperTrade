package dev.jlkeesh.papertrade.mapper.reference;

import dev.jlkeesh.papertrade.domains.reference.Currency;
import dev.jlkeesh.papertrade.dto.reference.CurrencyCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyDto;
import dev.jlkeesh.papertrade.dto.reference.CurrencyUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.*;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CurrencyMapper extends BaseMapper<Currency, CurrencyDto, CurrencyCreateDto, CurrencyUpdateDto> {
    Currency toEntity(CurrencyDto currencyDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Currency partialUpdate(CurrencyDto currencyDto, @MappingTarget Currency currency);
}

package dev.jlkeesh.papertrade.mapper;

import dev.jlkeesh.papertrade.domains.BaseDomain;
import dev.jlkeesh.papertrade.dto.Dto;
import lombok.NonNull;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @author : Elmurodov Javohir
 * @since : 01/06/23 / 09:36
 */


/**
 * @param <E>  : Domain Class (Entity)
 * @param <D>  : Data Transfer Object (DTO)
 * @param <CD> : DTO for create
 * @param <UD> : DTO for update
 * @description : Mapper for basic operations
 */
public interface BaseMapper<
        E extends BaseDomain,
        D extends Dto,
        CD extends Dto,
        UD extends Dto> extends GenericMapper {
    D toDto(@NonNull E domain);

    List<D> toDto(@NonNull List<E> domains);

    E fromCreateDto(@NonNull CD dto);

    E fromUpdateDto(@NonNull UD dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E partialUpdate(UD dto, @MappingTarget E domain);

}

package dev.jlkeesh.papertrade.mapper.reference;

import dev.jlkeesh.papertrade.domains.reference.Region;
import dev.jlkeesh.papertrade.dto.reference.RegionCreateDto;
import dev.jlkeesh.papertrade.dto.reference.RegionDto;
import dev.jlkeesh.papertrade.dto.reference.RegionUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.*;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RegionMapper extends BaseMapper<Region, RegionDto, RegionCreateDto, RegionUpdateDto> {
    Region toEntity(RegionDto regionDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Region partialUpdate(RegionDto regionDto, @MappingTarget Region region);
}

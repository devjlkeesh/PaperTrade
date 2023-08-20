package dev.jlkeesh.papertrade.mapper.main;

import dev.jlkeesh.papertrade.domains.main.Consignee;
import dev.jlkeesh.papertrade.dto.main.ConsigneeCreateDto;
import dev.jlkeesh.papertrade.dto.main.ConsigneeDto;
import dev.jlkeesh.papertrade.dto.main.ConsigneeUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.*;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ConsigneeMapper extends BaseMapper<Consignee, ConsigneeDto, ConsigneeCreateDto, ConsigneeUpdateDto> {
    Consignee toEntity(ConsigneeDto consigneeDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Consignee partialUpdate(ConsigneeDto consigneeDto, @MappingTarget Consignee consignee);
}

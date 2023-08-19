package dev.jlkeesh.papertrade.mapper.reference;

import dev.jlkeesh.papertrade.domains.reference.Category;
import dev.jlkeesh.papertrade.dto.reference.CategoryCreateDto;
import dev.jlkeesh.papertrade.dto.reference.CategoryDto;
import dev.jlkeesh.papertrade.dto.reference.CategoryUpdateDto;
import dev.jlkeesh.papertrade.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author : Elmurodov Javohir
 * @since : 19/08/23 / 08:22
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper extends BaseMapper<Category, CategoryDto, CategoryCreateDto, CategoryUpdateDto> {
}

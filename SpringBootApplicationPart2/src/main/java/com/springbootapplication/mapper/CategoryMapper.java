package com.springbootapplication.mapper;

import com.springbootapplication.dto.CategoryDto;
import com.springbootapplication.dto.CategoryResponseDto;
import com.springbootapplication.entity.Category;
import com.springbootapplication.utils.mapper.CategoryMapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {CategoryMapperUtil.class})
public interface CategoryMapper {
    // TO ENTITY
    Category toCategoryEntity(CategoryDto categoryDto);

    // TO DTO
    CategoryDto toCategoryDto(Category category); //map CategoryDto to CategoryResponseDto
    List<CategoryDto> toListCategoryDto(List<Category> categoryList); //map list of categoryDto to list of CategoryResponseDto

    // TO RESPONSE DTO
    CategoryResponseDto toCategoryResponseDto(CategoryDto categoryDto);
    List<CategoryResponseDto> toListCategoryResponseDto(List<CategoryDto> categoryList); //map list of categoryDto to list of CategoryResponseDto
}

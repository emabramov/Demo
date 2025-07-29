package com.springbootapplication.mapper;

import com.springbootapplication.dto.NewsDto;
import com.springbootapplication.dto.NewsResponseDto;
import com.springbootapplication.entity.News;
import com.springbootapplication.repositories.CategoryRepository;
import com.springbootapplication.utils.mapper.NewsMapperUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {NewsMapperUtil.class})

public interface NewsMapper {
    // TO ENTITY
    @Mapping(target = "category", qualifiedByName = {"NewsMapperUtil", "getCategory"}, source = "category")
    News toNewsEntity(NewsDto newsDto);

    // TO NEWSDto
    @Mapping(target = "category", expression = "java(news.getCategory().getTitle())")
    NewsDto toNewsDto(News news); //map NewsDto to NewsResponseDto
    List<NewsDto> toListNewsDto(List<News> newsList); //map list of NewsDto to list of NewsResponseDto

    // TO NEWS RESPONSE DTO
    @Mapping(target = "categoryName", expression = "java(newsDto.getCategory())")
    NewsResponseDto toNewsResponseDto(NewsDto newsDto); //map NewsDto to NewsResponseDto
    List<NewsResponseDto> toListNewsResponseDto(List<NewsDto> newsDtoList); //map list of NewsDto to list of NewsResponseDto

}

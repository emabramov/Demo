package com.springbootapplication.utils.mapper;

import com.springbootapplication.entity.Category;
import com.springbootapplication.repositories.CategoryRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Named("NewsMapperUtil")
@Component
@RequiredArgsConstructor
@Data
public class NewsMapperUtil {
    private final CategoryRepository categoryRepository;

    @Named("getCategory")
    public Category getCategory(String categoryName){
        return categoryRepository.findByTitle(categoryName);
    }
}

package com.springbootapplication.services;

import com.springbootapplication.dto.CategoryDto;
import com.springbootapplication.entity.Category;
import com.springbootapplication.exceptions.NotFoundException;
import com.springbootapplication.mapper.CategoryMapper;
import com.springbootapplication.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryCRUDService implements CRUDService<CategoryDto> {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto getById(Long id) throws NotFoundException{
        log.info("Get category by id " + id);
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Категория с id " + id + " не найдена."));
        return categoryMapper.toCategoryDto(category);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> getAll() throws NotFoundException{
            log.info("Get all categories");
            List<Category> allCategories = categoryRepository.findAll();
            if(allCategories.isEmpty()){
                throw new NotFoundException("Категорий нет");
            }
            return categoryMapper.toListCategoryDto(allCategories);
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        log.info("Create category " + categoryDto.getTitle());
        Category category = categoryMapper.toCategoryEntity(categoryDto);
        categoryRepository.save(category);
        categoryDto.setId(category.getId());
        return categoryDto;
    }

    @Override
    public void update(CategoryDto categoryDto) throws NotFoundException{
        log.info("Update category " + categoryDto.getTitle());
        Category categoryToUpdate = categoryRepository.findById(categoryDto.getId())
                .orElseThrow(() -> new NotFoundException("Категория с id " + categoryDto.getId() + " не найдена"));
        categoryRepository.save(categoryMapper.toCategoryEntity(categoryDto));
    }

    @Override
    public void delete(Long id) throws NotFoundException{
        log.warn("Delete category ");
        categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Категория с id " + id + " не найдена"));
        categoryRepository.deleteById(id);
    }

}

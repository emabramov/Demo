package com.springbootapplication.controllers;

import com.springbootapplication.dto.CategoryDto;
import com.springbootapplication.dto.CategoryResponseDto;
import com.springbootapplication.dto.ErrorDto;
import com.springbootapplication.exceptions.NotFoundException;

import com.springbootapplication.mapper.CategoryMapper;
import com.springbootapplication.services.CategoryCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private final CategoryCRUDService categoryCRUDService;
    private final ErrorDto errorDto = new ErrorDto();
    private final CategoryMapper categoryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDto createCategory(@RequestBody CategoryDto categoryDto){
        return categoryMapper.toCategoryResponseDto(categoryCRUDService.create(categoryDto));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponseDto getCategoryById(@PathVariable Long id) throws NotFoundException{
        return categoryMapper.toCategoryResponseDto(categoryCRUDService.getById(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponseDto> getAll() throws NotFoundException{
        return categoryMapper.toListCategoryResponseDto(categoryCRUDService.getAll());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) throws NotFoundException{
        categoryCRUDService.update(categoryDto);
        return categoryCRUDService.getById(categoryDto.getId());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable Long id) throws NotFoundException{
        categoryCRUDService.delete(id);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFoundException(NotFoundException ex){
        errorDto.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
}

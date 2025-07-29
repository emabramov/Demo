package com.springbootapplication.controllers;

import com.springbootapplication.dto.ErrorDto;
import com.springbootapplication.dto.NewsDto;
import com.springbootapplication.dto.NewsResponseDto;
import com.springbootapplication.entity.News;
import com.springbootapplication.exceptions.NotFoundException;
import com.springbootapplication.mapper.NewsMapper;
import com.springbootapplication.services.CategoryCRUDService;
import com.springbootapplication.services.NewsCRUDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    @Autowired
    private final NewsCRUDService newsService;
    private final ErrorDto errorDTO = new ErrorDto();
    private final NewsMapper newsMapper;


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsResponseDto getNewsById(@PathVariable Long id) throws NotFoundException{
        return newsMapper.toNewsResponseDto(newsService.getById(id));
    }

    @GetMapping
    public List<NewsResponseDto> getAllNews(){
        return newsService.getAll().stream()
                .map(newsMapper::toNewsResponseDto)
                .toList();
    }

    @GetMapping("/category/{id}")
    public List<NewsResponseDto> getNewsByCategory(@PathVariable Long id){
        List<News> news = newsService.getAll()
                .stream()
                .map(newsMapper::toNewsEntity)
                .filter(news1 -> news1.getCategory().getId().equals(id))
                .toList();
        return newsMapper.toListNewsResponseDto(newsMapper.toListNewsDto(news));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public NewsResponseDto createNews(@RequestBody NewsDto newsDTO){
        NewsDto createdNews = newsService.create(newsDTO);
        return newsMapper.toNewsResponseDto(createdNews);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsResponseDto updateNews(@PathVariable Long id, @RequestBody NewsDto newsDTO) throws NotFoundException {
        newsService.update(newsDTO);
        return newsMapper.toNewsResponseDto(newsService.getById(newsDTO.getId()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNews(@PathVariable Long id) throws NotFoundException{
        newsService.delete(id);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFoundException(NotFoundException ex){
        errorDTO.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}

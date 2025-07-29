package com.springbootapplication.services;

import com.springbootapplication.dto.NewsDto;
import com.springbootapplication.entity.Category;
import com.springbootapplication.entity.News;
import com.springbootapplication.exceptions.NotFoundException;
import com.springbootapplication.mapper.NewsMapper;
import com.springbootapplication.repositories.CategoryRepository;
import com.springbootapplication.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsCRUDService implements CRUDService<NewsDto> {
    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;
    private final NewsMapper newsMapper;


    @Override
    public NewsDto getById(Long id) throws NotFoundException{
        log.info("Get news with id {}", id);
        News news = newsRepository.findById(id).orElseThrow(() -> new NotFoundException("Новость с id %d не найдена".formatted(id)));
        return newsMapper.toNewsDto(news);
    }

    @Override
    public List<NewsDto> getAll() throws NotFoundException{
        List<News> newsList = newsRepository.findAll();
        if(newsList.isEmpty()){
            throw new NotFoundException("Новостей нет");
        }
        return newsList.stream()
                .map(newsMapper::toNewsDto)
                .toList();
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        Category category = categoryRepository.findByTitle(newsDto.getCategory());
        News news = newsMapper.toNewsEntity(newsDto);
        news.setCategory(category);
        news.setTime(Instant.now());
        newsRepository.save(news);
        newsDto = newsMapper.toNewsDto(news);
        return newsDto;
    }

    @Override
    public void update(NewsDto newsDto) throws NotFoundException {
        log.info("Обновление новости с id {}", newsDto.getId());
        News newsToUpdate = newsRepository.findById(newsDto.getId())
                .orElseThrow(() -> new NotFoundException("Новости с id %d не существует".formatted(newsDto.getId())));
        newsToUpdate.setCategory(categoryRepository.findByTitle(newsDto.getCategory()));
        newsToUpdate.setTime(Instant.now());
        newsDto.setTime(newsToUpdate.getTime());
        newsRepository.save(newsMapper.toNewsEntity(newsDto));
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        log.info("Delete news with id {}", id);
        newsRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Новости с id %d не существует".formatted(id)));
        newsRepository.deleteById(id);
    }
}

package com.springbootapplication.controllers;

import com.springbootapplication.dto.ErrorDTO;
import com.springbootapplication.dto.NewsDTO;
import com.springbootapplication.services.NewsCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsCRUDService newsService;
    private ErrorDTO errorDTO = new ErrorDTO("");

    @GetMapping("/{id}")
    public ResponseEntity getNewsById(@PathVariable Long id){
        if(newsService.getById(id) != null){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(newsService.getById(id));
        }
        errorDTO.setMessage("News with id " + id + " is not found");
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errorDTO);
    }

    @GetMapping
    public Collection<NewsDTO> getAllNews(){return newsService.getAll();}

    @PostMapping
    public ResponseEntity createNews(@RequestBody NewsDTO newsDTO){
        newsService.create(newsDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(newsDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNews(@PathVariable Long id, @RequestBody NewsDTO newsDTO){
        if(newsService.getById(id) == null){
            errorDTO.setMessage("News with id " + id + " is not found");
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errorDTO);
        }
        newsService.update(id, newsDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(newsDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNews(@PathVariable Long id){
        if(newsService.getById(id) == null){
            errorDTO.setMessage("News with id " + id + " is not found");
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(errorDTO);
        }
        newsService.delete(id);
        errorDTO.setMessage("News with id " + id + " is deleted");
        return ResponseEntity.status(HttpStatusCode.valueOf(204)).body(errorDTO);
    }
}

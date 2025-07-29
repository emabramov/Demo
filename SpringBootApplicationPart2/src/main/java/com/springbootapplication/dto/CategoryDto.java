package com.springbootapplication.dto;

import com.springbootapplication.entity.News;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String title;
    private List<News> news;
}

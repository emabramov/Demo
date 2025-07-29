package com.springbootapplication.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Getter
@Setter
public class NewsResponseDto {
    private Long id;
    private String title;
    private String text;
    private Instant time;
    private String categoryName;
}

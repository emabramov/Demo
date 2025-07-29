package com.springbootapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class NewsDTO {
    private Long id;
    private String title;
    private String text;
    private Instant date;
}

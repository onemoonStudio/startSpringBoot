package com.example.webdemo.dto;

import com.example.webdemo.domain.constant.Season;
import lombok.Data;

@Data
public class EnumRequestDto {
    Season season;
    String test;
}

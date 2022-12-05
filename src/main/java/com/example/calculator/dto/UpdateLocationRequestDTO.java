package com.example.calculator.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateLocationRequestDTO {
    private String name;
    private int x;
    private int y;
}

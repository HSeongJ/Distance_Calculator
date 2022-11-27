package com.example.calculator.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class InsertRequestDTO {
    private String name;
    private int x;
    private int y;
}

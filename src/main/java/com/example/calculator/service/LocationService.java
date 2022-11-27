package com.example.calculator.service;

import com.example.calculator.dto.LocationRequestDTO;
import com.example.calculator.dto.LocationResponseDTO;

public interface LocationService {
    LocationResponseDTO distance(LocationRequestDTO requestDTO);
    LocationResponseDTO distance2(LocationRequestDTO requestDTO);
}

package com.example.calculator.service;

import com.example.calculator.dto.*;

import java.util.List;

public interface LocationService {
    LocationResponseDTO distance(LocationRequestDTO requestDTO);

    LocationResponseDTO distance2(LocationRequestDTO requestDTO);

    List<FindResponseDTO> searchList();     // 전체 데이터 조회

    String addLocation (InsertRequestDTO requestDTO);

    String deleteLocation(DeleteRequestDTO requestDTO);
}

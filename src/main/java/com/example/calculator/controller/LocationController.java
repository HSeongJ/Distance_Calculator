package com.example.calculator.controller;

import com.example.calculator.dto.FindResponseDTO;
import com.example.calculator.dto.LocationRequestDTO;
import com.example.calculator.dto.LocationResponseDTO;
import com.example.calculator.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/distance")
    public LocationResponseDTO distance(@RequestParam("requestDTO") LocationRequestDTO requestDTO) {
        return locationService.distance(requestDTO);
    }

    @GetMapping("/distance2")
    public LocationResponseDTO distance2(@RequestParam("requestDTO") LocationRequestDTO requestDTO) {
        return locationService.distance2(requestDTO);
    }

    @GetMapping("/list")
    public List<FindResponseDTO> list() {
        return  locationService.searchList();
    }


}

package com.example.calculator.service;

import com.example.calculator.dto.LocationRequestDTO;
import com.example.calculator.dto.LocationResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @Test
    public void distanceTest() {
        LocationRequestDTO dto = new LocationRequestDTO();
        dto.setLocation_name1("home");
        dto.setLocation_name2("school");
        LocationResponseDTO responseDTO = locationService.distance(dto);
        System.out.println(responseDTO.getResult());
    }

    @Test
    public void distance2Test() {
        LocationRequestDTO dto = new LocationRequestDTO();
        dto.setLocation_name1("home");
        dto.setLocation_name2("school");
        Assertions.assertEquals(2.83, locationService.distance2(dto).getResult());
    }

    @Test
    public void searchList() {
        Assertions.assertEquals(3, locationService.searchList().size());
    }
}

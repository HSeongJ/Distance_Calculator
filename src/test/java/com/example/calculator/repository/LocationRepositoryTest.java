package com.example.calculator.repository;

import com.example.calculator.dto.DeleteRequestDTO;
import com.example.calculator.dto.FindResponseDTO;
import com.example.calculator.dto.InsertRequestDTO;
import com.example.calculator.dto.LocationRequestDTO;
import com.example.calculator.entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void distance2Test() {
        LocationRequestDTO dto = new LocationRequestDTO();
        dto.setLocation_name1("home");
        dto.setLocation_name2("cafe");
        Assertions.assertEquals("5.66", locationRepository.distance2(dto).toString());
    }

    @Test
    public void test() {
        System.out.println(locationRepository.findAll());
    }

    @Test
    public void deleteByNameTest(){

        locationRepository.deleteByName("dd");
    }

}

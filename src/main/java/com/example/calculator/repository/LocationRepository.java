package com.example.calculator.repository;

import com.example.calculator.dto.LocationRequestDTO;
import com.example.calculator.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l.x, l.y FROM Location l WHERE name = :locationName")
    List<Object[]> distance(@Param("locationName") String locationName);

    @Query("SELECT round(sqrt(pow(max(l.x) - min(l.x), 2) + pow(max(l.y) - min(l.y), 2)), 2)" +
            " FROM Location l" +
            " WHERE l.name = :#{#requestDTO.location_name1} or l.name = :#{#requestDTO.location_name2}")
    Object distance2(@Param("requestDTO") LocationRequestDTO requestDTO);

    
}

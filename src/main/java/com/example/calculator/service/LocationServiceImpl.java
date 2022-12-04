package com.example.calculator.service;

import com.example.calculator.dto.*;
import com.example.calculator.entity.Location;
import com.example.calculator.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationResponseDTO distance(LocationRequestDTO requestDTO) {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

        List<Object[]> list = locationRepository.distance(requestDTO.getLocation_name1());
        List<Object[]> list2 = locationRepository.distance(requestDTO.getLocation_name2());

        for(Object[] result : list) {
            x1 = (int) result[0];
            y1 = (int) result[1];
        }

        for(Object[] result : list2) {
            x2 = (int) result[0];
            y2 = (int) result[1];
        }

        Double result = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        result = Math.round(result * 100) / 100.0;
        LocationResponseDTO responseDTO = new LocationResponseDTO();
        responseDTO.setResult(result);
        return responseDTO;
    }

    @Override
    public LocationResponseDTO distance2(LocationRequestDTO requestDTO) {
        Double result = (Double) locationRepository.distance2(requestDTO);
        LocationResponseDTO responseDTO = new LocationResponseDTO();
        responseDTO.setResult(result);
        return responseDTO;
    }

    @Override
    public List<FindResponseDTO> searchList() {
        List<Location> list = locationRepository.findAll();
        List<FindResponseDTO> result = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            FindResponseDTO dto = new FindResponseDTO();
            dto.setName(list.get(i).getName());
            dto.setX(list.get(i).getX());
            dto.setY(list.get(i).getY());
            result.add(dto);
        }

        return result;
    }

    @Override
    public String addLocation(InsertRequestDTO requestDTO) {
        try {

            Location location = new Location();
            location.setName(requestDTO.getName());
            location.setX(requestDTO.getX());
            location.setY(requestDTO.getY());

            locationRepository.save(location);
            return "데이터가 정상적으로 추가되었습니다.";
        }catch (Exception e) {
            return "ID가 중복 되었습니다.";
        }
    }

    @Override
    public String deleteLocation(DeleteRequestDTO requestDTO) {

        try {
            locationRepository.deleteByName(requestDTO.getName());

            return "데이터가 정상적으로 삭제되었습니다.";
        } catch(Exception e) {
            return "ID가 존재하지 않습니다.";
        }

    }

}

package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.CountyDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICountyService {

    CountyDTO.CountyResponseDTO saveCounty(CountyDTO.CountyCreateDTO countyDTO);

    CountyDTO.CountyResponseDTO updateCounty(CountyDTO.CountyCreateDTO countyDTO, Long id);

    String deleteCounty(Long id);

    List<CountyDTO.CountyResponseDTO> findAllCounty();

    List<CountyDTO.CountyResponseDTO> findAllByOrderByIdAsc();

    CountyDTO.CountyResponseDTO findCountyById(Long id);
}
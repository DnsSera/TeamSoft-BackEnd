package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.RaceDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRaceService {

    RaceDTO.RaceResponseDTO saveRace(RaceDTO.RaceCreateDTO raceDTO);

    RaceDTO.RaceResponseDTO updateRace(RaceDTO.RaceCreateDTO raceDTO, Long id);

    String deleteRace(Long id);

    List<RaceDTO.RaceResponseDTO> findAllRace();

    List<RaceDTO.RaceResponseDTO> findAllByOrderByIdAsc();

    RaceDTO.RaceResponseDTO findRaceById(Long id);
}
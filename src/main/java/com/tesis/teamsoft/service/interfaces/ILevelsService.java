package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.LevelsDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILevelsService {

    LevelsDTO.LevelsResponseDTO saveLevels(LevelsDTO.LevelsCreateDTO levelsDTO);

    LevelsDTO.LevelsResponseDTO updateLevels(LevelsDTO.LevelsCreateDTO levelsDTO, Long id);

    String deleteLevels(Long id);

    List<LevelsDTO.LevelsResponseDTO> findAllLevels();

    List<LevelsDTO.LevelsResponseDTO> findAllByOrderByIdAsc();

    LevelsDTO.LevelsResponseDTO findLevelsById(Long id);
}
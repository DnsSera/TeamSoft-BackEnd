package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.CompetenceImportanceDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompetenceImportanceService {

    CompetenceImportanceDTO.CompetenceImportanceResponseDTO saveCompetenceImportance(
            CompetenceImportanceDTO.CompetenceImportanceCreateDTO competenceImportanceDTO);

    CompetenceImportanceDTO.CompetenceImportanceResponseDTO updateCompetenceImportance(
            CompetenceImportanceDTO.CompetenceImportanceCreateDTO competenceImportanceDTO, Long id);

    String deleteCompetenceImportance(Long id);

    List<CompetenceImportanceDTO.CompetenceImportanceResponseDTO> findAllCompetenceImportance();

    List<CompetenceImportanceDTO.CompetenceImportanceResponseDTO> findAllByOrderByIdAsc();

    CompetenceImportanceDTO.CompetenceImportanceResponseDTO findCompetenceImportanceById(Long id);
}
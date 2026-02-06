package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.ProjectStructureDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectStructureService {

    ProjectStructureDTO.ProjectStructureResponseDTO saveProjectStructure(
            ProjectStructureDTO.ProjectStructureCreateDTO projectStructureDTO);

    ProjectStructureDTO.ProjectStructureResponseDTO updateProjectStructure(
            ProjectStructureDTO.ProjectStructureCreateDTO projectStructureDTO, Long id);

    String deleteProjectStructure(Long id);

    List<ProjectStructureDTO.ProjectStructureSimpleDTO> findAllProjectStructure();

    ProjectStructureDTO.ProjectStructureResponseDTO findProjectStructureById(Long id);
}
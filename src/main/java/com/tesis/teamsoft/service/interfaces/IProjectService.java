package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.ProjectDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectService {

    List<ProjectDTO.ProjectResponseDTO> saveProjects(List<ProjectDTO.ProjectCreateDTO> projectDTOs);

    ProjectDTO.ProjectResponseDTO updateProject(ProjectDTO.ProjectCreateDTO projectDTO, Long id);

    String deleteProject(Long id);

    List<ProjectDTO.ProjectSimpleDTO> findAllProjects();

    ProjectDTO.ProjectResponseDTO findProjectById(Long id);
}
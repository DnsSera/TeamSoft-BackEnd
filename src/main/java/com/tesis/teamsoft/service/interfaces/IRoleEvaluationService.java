package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.RoleEvaluationDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleEvaluationService {

    RoleEvaluationDTO.RoleEvaluationResponseDTO saveRoleEvaluation(RoleEvaluationDTO.RoleEvaluationCreateDTO roleEvaluationDTO);

    RoleEvaluationDTO.RoleEvaluationResponseDTO updateRoleEvaluation(RoleEvaluationDTO.RoleEvaluationCreateDTO roleEvaluationDTO, Long id);

    String deleteRoleEvaluation(Long id);

    List<RoleEvaluationDTO.RoleEvaluationResponseDTO> findAllRoleEvaluation();

    List<RoleEvaluationDTO.RoleEvaluationResponseDTO> findAllByOrderByIdAsc();

    RoleEvaluationDTO.RoleEvaluationResponseDTO findRoleEvaluationById(Long id);
}
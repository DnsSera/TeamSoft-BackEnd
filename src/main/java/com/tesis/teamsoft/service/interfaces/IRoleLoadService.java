package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.RoleLoadDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleLoadService {

    RoleLoadDTO.RoleLoadResponseDTO saveRoleLoad(RoleLoadDTO.RoleLoadCreateDTO roleLoadDTO);

    RoleLoadDTO.RoleLoadResponseDTO updateRoleLoad(RoleLoadDTO.RoleLoadCreateDTO roleLoadDTO, Long id);

    String deleteRoleLoad(Long id);

    List<RoleLoadDTO.RoleLoadResponseDTO> findAllRoleLoad();

    List<RoleLoadDTO.RoleLoadResponseDTO> findAllByOrderByIdAsc();

    RoleLoadDTO.RoleLoadResponseDTO findRoleLoadById(Long id);
}
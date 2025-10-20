package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.PersonGroupDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonGroupService {

    PersonGroupDTO.PersonGroupResponseDTO savePersonGroup(PersonGroupDTO.PersonGroupCreateDTO personGroupDTO);

    PersonGroupDTO.PersonGroupResponseDTO updatePersonGroup(PersonGroupDTO.PersonGroupCreateDTO personGroupDTO, Long id);

    String deletePersonGroup(Long id);

    List<PersonGroupDTO.PersonGroupResponseDTO> findAllPersonGroup();

    List<PersonGroupDTO.PersonGroupResponseDTO> findAllByOrderByIdAsc();

    PersonGroupDTO.PersonGroupResponseDTO findPersonGroupById(Long id);
}
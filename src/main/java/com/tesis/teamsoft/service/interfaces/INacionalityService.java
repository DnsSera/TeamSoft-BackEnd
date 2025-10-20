package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.NacionalityDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INacionalityService {

    NacionalityDTO.NacionalityResponseDTO saveNacionality(NacionalityDTO.NacionalityCreateDTO nacionalityDTO);

    NacionalityDTO.NacionalityResponseDTO updateNacionality(NacionalityDTO.NacionalityCreateDTO nacionalityDTO, Long id);

    String deleteNacionality(Long id);

    List<NacionalityDTO.NacionalityResponseDTO> findAllNacionality();

    List<NacionalityDTO.NacionalityResponseDTO> findAllByOrderByIdAsc();

    NacionalityDTO.NacionalityResponseDTO findNacionalityById(Long id);
}
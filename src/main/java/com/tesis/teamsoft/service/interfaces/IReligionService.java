package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.ReligionDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReligionService {

    ReligionDTO saveReligion(ReligionDTO religionDTO);

    ReligionDTO updateReligion(ReligionDTO religionDTO, Long id);

    String deleteReligion(Long id);

    List<ReligionDTO> findAllReligion();

    List<ReligionDTO> findAllByOrderByIdAsc();

    ReligionDTO findReligionById(Long id);
}

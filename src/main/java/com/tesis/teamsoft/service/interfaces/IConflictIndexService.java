package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.ConflictIndexDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IConflictIndexService {

    ConflictIndexDTO.ConflictIndexResponseDTO saveConflictIndex(ConflictIndexDTO.ConflictIndexCreateDTO conflictIndexDTO);

    ConflictIndexDTO.ConflictIndexResponseDTO updateConflictIndex(ConflictIndexDTO.ConflictIndexCreateDTO conflictIndexDTO, Long id);

    String deleteConflictIndex(Long id);

    List<ConflictIndexDTO.ConflictIndexResponseDTO> findAllConflictIndex();

    List<ConflictIndexDTO.ConflictIndexResponseDTO> findAllByOrderByIdAsc();

    ConflictIndexDTO.ConflictIndexResponseDTO findConflictIndexById(Long id);
}
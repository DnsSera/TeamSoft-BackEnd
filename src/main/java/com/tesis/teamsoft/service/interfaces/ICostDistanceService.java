package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.CostDistanceDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICostDistanceService {

    CostDistanceDTO.CostDistanceResponseDTO saveCostDistance(CostDistanceDTO.CostDistanceCreateDTO costDistanceDTO);

    CostDistanceDTO.CostDistanceResponseDTO updateCostDistance(CostDistanceDTO.CostDistanceCreateDTO costDistanceDTO, Long id);

    String deleteCostDistance(Long id);

    List<CostDistanceDTO.CostDistanceResponseDTO> findAllCostDistance();

    List<CostDistanceDTO.CostDistanceResponseDTO> findAllByOrderByIdAsc();

    CostDistanceDTO.CostDistanceResponseDTO findCostDistanceById(Long id);
}
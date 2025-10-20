package com.tesis.teamsoft.service.interfaces;

import com.tesis.teamsoft.presentation.dto.ClientDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientService {

    ClientDTO.ClientResponseDTO saveClient(ClientDTO.ClientCreateDTO clientDTO);

    ClientDTO.ClientResponseDTO updateClient(ClientDTO.ClientCreateDTO clientDTO, Long id);

    String deleteClient(Long id);

    List<ClientDTO.ClientResponseDTO> findAllClient();

    List<ClientDTO.ClientResponseDTO> findAllByOrderByIdAsc();

    ClientDTO.ClientResponseDTO findClientById(Long id);
}
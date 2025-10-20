package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class NacionalityDTO {

    @Data
    public static class NacionalityCreateDTO {
        @NotBlank(message = "Country name is required")
        private String paisNac;

        @NotBlank(message = "Demonym is required")
        private String gentilicioNac;
    }

    @Data
    public static class NacionalityResponseDTO {
        private Long id;
        private String paisNac;
        private String gentilicioNac;
    }
}
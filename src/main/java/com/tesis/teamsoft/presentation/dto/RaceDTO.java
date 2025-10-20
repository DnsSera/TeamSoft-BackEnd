package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RaceDTO {

    @Data
    public static class RaceCreateDTO {
        @NotBlank(message = "Race name is required")
        private String raceName;
    }

    @Data
    public static class RaceResponseDTO {
        private Long id;
        private String raceName;
    }
}
package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LevelsDTO {

    @Data
    public static class LevelsCreateDTO {

        @Min(value = 0, message = "Level must be at least 0")
        @NotNull(message = "Level is required")
        private Long levels;

        @NotBlank(message = "Significance is required")
        private String significance;
    }

    @Data
    public static class LevelsResponseDTO {
        private Long id;
        private Long levels;
        private String significance;
    }
}
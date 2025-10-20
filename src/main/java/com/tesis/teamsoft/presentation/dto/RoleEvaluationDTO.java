package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleEvaluationDTO {

    @Data
    public static class RoleEvaluationCreateDTO {
        @NotNull(message = "Levels is required")
        @Min(value = 0, message = "Levels must be at least 0")
        private Float levels;

        @NotBlank(message = "Significance is required")
        private String significance;
    }

    @Data
    public static class RoleEvaluationResponseDTO {
        private Long id;
        private Float levels;
        private String significance;
    }
}
package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoleLoadDTO {

    @Data
    public static class RoleLoadCreateDTO {
        @NotNull(message = "Value is required")
        private Float value;

        @NotBlank(message = "Significance is required")
        private String significance;
    }

    @Data
    public static class RoleLoadResponseDTO {
        private Long id;
        private Float value;
        private String significance;
    }
}
package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CountyDTO {

    @Data
    public static class CountyCreateDTO {
        @NotBlank(message = "County name is required")
        private String countyName;

        @NotBlank(message = "Code is required")
        private String code;
    }

    @Data
    public static class CountyResponseDTO {
        private Long id;
        private String countyName;
        private String code;
    }
}
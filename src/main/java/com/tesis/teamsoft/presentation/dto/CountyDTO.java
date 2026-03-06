package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CountyDTO {

    @Data
    public static class CountyCreateDTO {
        @NotBlank(message = "County name is required")
        @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Only letters and spaces are allowed")
        private String countyName;

        @NotBlank(message = "Code is required")
        @Pattern(regexp = "^[0-9]+$", message = "Phone can only contain digits, spaces, plus and hyphen")
        private String code;
    }

    @Data
    public static class CountyResponseDTO {
        private Long id;
        private String countyName;
        private String code;
    }
}
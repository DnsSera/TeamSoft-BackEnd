package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClientDTO {

    @Data
    public static class ClientCreateDTO {
        @NotBlank(message = "Entity name is required")
        @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Only letters and spaces are allowed")
        private String entityName;

        @NotBlank(message = "Address is required")
        private String address;

        @NotBlank(message = "Phone is required")
        @Pattern(regexp = "^[0-9]+$", message = "Phone can only contain digits, spaces, plus and hyphen")
        private String phone;

        @AssertTrue(message = "Phone must contain at least 8 numeric digits")
        public boolean isPhoneValid() {
            if (phone == null) return false;
            String digitsOnly = phone.replaceAll("[^0-9]", "");
            return digitsOnly.length() >= 8;
        }
    }

    @Data
    public static class ClientResponseDTO {
        private Long id;
        private String entityName;
        private String address;
        private String phone;
    }
}
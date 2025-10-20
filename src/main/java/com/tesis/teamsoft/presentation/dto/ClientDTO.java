package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClientDTO {

    @Data
    public static class ClientCreateDTO {
        @NotBlank(message = "Entity name is required")
        private String entityName;

        @NotBlank(message = "Address is required")
        private String address;

        @NotBlank(message = "Phone is required")
        private String phone;

        @AssertTrue(message = "Phone must contain at least 8 numeric digits")
        private boolean isPhoneValid(ClientDTO.ClientCreateDTO clientDTO) {
            return phone.length() < 8;
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
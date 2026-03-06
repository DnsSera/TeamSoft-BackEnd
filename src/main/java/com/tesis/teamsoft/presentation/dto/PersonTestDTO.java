package com.tesis.teamsoft.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

public class PersonTestDTO {

    @Data
    public static class PersonTestCreateDTO {
        @NotNull(message = "ES is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("e_S")
        private Character e_S;

        @NotNull(message = "ID is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("i_D")
        private Character i_D;

        @NotNull(message = "CO is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("c_O")
        private Character c_O;

        @NotNull(message = "IS is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("i_S")
        private Character i_S;

        @NotNull(message = "CE is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("c_E")
        private Character c_E;

        @NotNull(message = "IR is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("i_R")
        private Character i_R;

        @NotNull(message = "ME is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("m_E")
        private Character m_E;

        @NotNull(message = "CH is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("c_H")
        private Character c_H;

        @NotNull(message = "IF is required")
        @Pattern(regexp = "^[PEI]$", message = "Only P, E or I are allowed")
        @JsonProperty("i_F")
        private Character i_F;

        @NotBlank(message = "MBTI test result is required")
        @Pattern(regexp = "^(ISTJ|ISFJ|INFJ|INTJ|ISTP|ISFP|INFP|INTP|ESTP|ESFP|ENFP|ENTP|ESTJ|ESFJ|ENFJ|ENTJ)$", 
                 message = "Must be a valid MBTI type")
        private String tipoMB;
    }

    @Data
    public static class PersonTestResponseDTO {
        private Long id;
        private Character e_S;
        private Character i_D;
        private Character c_O;
        private Character i_S;
        private Character c_E;
        private Character i_R;
        private Character m_E;
        private Character c_H;
        private Character i_F;
        private String tipoMB;
    }
}

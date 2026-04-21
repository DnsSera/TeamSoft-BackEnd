package com.tesis.teamsoft.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tesis.teamsoft.persistence.entity.auxiliary.BelbinRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonTestDTO {

    @Data
    public static class PersonTestCreateDTO {
        @NotNull(message = "ES is required")
        @JsonProperty("e_S")
        private BelbinRole eS;

        @NotNull(message = "ID is required")
        @JsonProperty("i_D")
        private BelbinRole iM;

        @NotNull(message = "CO is required")
        @JsonProperty("c_O")
        private BelbinRole cO;

        @NotNull(message = "IS is required")
        @JsonProperty("i_S")
        private BelbinRole iS;

        @NotNull(message = "CE is required")
        @JsonProperty("c_E")
        private BelbinRole cE;

        @NotNull(message = "IR is required")
        @JsonProperty("i_R")
        private BelbinRole iR;

        @NotNull(message = "ME is required")
        @JsonProperty("m_E")
        private BelbinRole mE;

        @NotNull(message = "CH is required")
        @JsonProperty("c_H")
        private BelbinRole cH;

        @NotNull(message = "IF is required")
        @JsonProperty("i_F")
        private BelbinRole iF;

        @NotBlank(message = "MBTI test result is required")
        @Pattern(regexp = "^(E|I)(N|S)(F|T)(J|P)$", message = "Must be a valid MBTI type like 'ENFJ'")
        private String mbtiType;
    }

    @Data
    public static class PersonTestResponseDTO {
        private Long id;
        private BelbinRole eS;
        private BelbinRole iM;
        private BelbinRole cO;
        private BelbinRole iS;
        private BelbinRole cE;
        private BelbinRole iR;
        private BelbinRole mE;
        private BelbinRole cH;
        private BelbinRole iF;
        private String mbtiType;
    }
}

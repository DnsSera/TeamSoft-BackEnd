package com.tesis.teamsoft.presentation.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Schema(description = "Create Religion")
public class ReligionDTO {


    @Data
    public static class ReligionCreateDTO {
        private String religionName;

    }

    @Data
    public static class ReligionResponseDTO {
        private Long id;
        private String religionName;
    }


}

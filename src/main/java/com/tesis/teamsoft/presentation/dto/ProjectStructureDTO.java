package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class ProjectStructureDTO {

    @Data
    public static class ProjectStructureCreateDTO {
        @NotBlank(message = "Name is required")
        @Size(min = 1, max = 1024)
        private String name;

        @Valid
        @NotNull(message = "Project roles are required")
        @Size(min = 1, message = "At least one project role is required")
        private List<ProjectRoleDTO.ProjectRoleCreateDTO> projectRoles;
    }

    @Data
    public static class ProjectStructureResponseDTO {
        private Long id;
        private String name;
        private List<ProjectRoleDTO.ProjectRoleResponseDTO> projectRoles;
    }

    @Data
    public static class ProjectStructureSimpleDTO {
        private Long id;
        private String name;
    }



    // DTO auxiliar para RoleLoad (si no existe)
    @Data
    public static class RoleLoadDTO {
        private Long id;
        private String name;
        // Agrega otros campos según tu entidad RoleLoadEntity
    }
}
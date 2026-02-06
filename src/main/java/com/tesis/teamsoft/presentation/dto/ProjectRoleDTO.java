package com.tesis.teamsoft.presentation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProjectRoleDTO {

    @Data
    public static class ProjectRoleCreateDTO {
        @NotNull(message = "Role ID is required")
        private Long role;

        @NotNull(message = "Role Load ID is required")
        private Long roleLoad;

        @NotNull(message = "Amount of workers is required")
        private Long amountWorkersRole;
    }

    @Data
    public static class ProjectRoleResponseDTO {
        private Long id;
        private Long amountWorkersRole;
        private RoleDTO.RoleMinimalDTO role;
        private RoleLoadDTO.RoleLoadResponseDTO roleLoad;

    }
}

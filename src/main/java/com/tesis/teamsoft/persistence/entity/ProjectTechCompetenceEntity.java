package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project_tech_competence")
public class ProjectTechCompetenceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectTechCompetenceSeq")
    @SequenceGenerator(name = "projectTechCompetenceSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Competence is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "competence_fk", nullable = false)
    private CompetenceEntity competence;

    @NotNull(message = "Competence importance is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "competence_importance_fk", nullable = false)
    private CompetenceImportanceEntity competenceImportance;

    @NotNull(message = "Level is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "level_fk", nullable = false)
    private LevelsEntity level;

    @NotNull(message = "Project roles is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "project_roles", nullable = false)
    private ProjectRolesEntity projectRoles;

    @Override
    public boolean equals(Object object) {
        if (object instanceof ProjectTechCompetenceEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
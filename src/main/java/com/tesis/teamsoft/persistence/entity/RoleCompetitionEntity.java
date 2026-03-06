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
@Table(name = "role_competition")
public class RoleCompetitionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleCompetitionSeq")
    @SequenceGenerator(name = "roleCompetitionSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Competence is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "competence_fk", nullable = false)
    private CompetenceEntity competence;

    @NotNull(message = "Competence importance is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "competence_importance_", nullable = false)
    private CompetenceImportanceEntity competenceImportance;

    @NotNull(message = "Level is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "levels_fk", nullable = false)
    private LevelsEntity level;

    @NotNull(message = "Role is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "roles_fk", nullable = false)
    private RoleEntity role;

    @Override
    public boolean equals(Object object) {
        if (object instanceof RoleCompetitionEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
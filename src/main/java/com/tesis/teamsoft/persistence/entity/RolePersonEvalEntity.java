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
@Table(name = "role_person_eval")
public class RolePersonEvalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolePersonEvalSeq")
    @SequenceGenerator(name = "rolePersonEvalSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Cycle is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "cycle_fk", nullable = false)
    private CycleEntity cycles;

    // Relación opcional
    @ManyToOne
    @JoinColumn(name = "roles_fk")
    private RoleEntity roles;

    @NotNull(message = "Role evaluation is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_evaluation_fk", nullable = false)
    private RoleEvaluationEntity roleEvaluation;

    // Relación opcional
    @ManyToOne
    @JoinColumn(name = "person_fk")
    private PersonEntity person;

    @Override
    public boolean equals(Object object) {
        if (object instanceof RolePersonEvalEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
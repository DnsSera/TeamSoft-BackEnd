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
@Table(name = "competence_value")
public class CompetenceValueEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competenceValueSeq")
    @SequenceGenerator(name = "competenceValueSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Competence is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "competence_fk", nullable = false)
    private CompetenceEntity competence;

    @NotNull(message = "Level is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "levels_fk", nullable = false)
    private LevelsEntity level;

    @NotNull(message = "Person is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_fk", nullable = false)
    private PersonEntity person;

    @Override
    public boolean equals(Object object) {
        if (object instanceof CompetenceValueEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
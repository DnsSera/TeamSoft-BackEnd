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
@Table(name = "personal_project_interests")
public class PersonalProjectInterestsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personalProjectInterestsSeq")
    @SequenceGenerator(name = "personalProjectInterestsSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private boolean preference;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "project_fk", nullable = false)
    private ProjectEntity project;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_fk", nullable = false)
    private PersonEntity person;

    @Override
    public boolean equals(Object object) {
        if (object instanceof PersonalProjectInterestsEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
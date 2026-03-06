package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nacionality")
public class NacionalityEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nacionalitySeq")
    @SequenceGenerator(name = "nacionalitySeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Country name is required")
    @Column(name = "pais_nac", nullable = false, unique = true)
    private String paisNac;

    @NotNull(message = "Demonym is required")
    @Column(name = "gentilicio_nac", nullable = false, unique = true)
    private String gentilicioNac;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionality")
    private List<PersonEntity> personList;

    @Override
    public boolean equals(Object object) {
        if (object instanceof NacionalityEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
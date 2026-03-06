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
@Table(name = "religion")
public class ReligionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "religionSeq")
    @SequenceGenerator(name = "religionSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Religion name is required")
    @Column(name = "religion_name", nullable = false, unique = true)
    private String religionName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "religion")
    private List<PersonEntity> personList;

    @Override
    public boolean equals(Object object) {
        if (object instanceof ReligionEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
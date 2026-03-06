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
@Table(name = "project_structure")
public class ProjectStructureEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectStructureSeq")
    @SequenceGenerator(name = "projectStructureSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Name is required")
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectStructure")
    private List<CycleEntity> cycleList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectStructure", orphanRemoval = true)
    private List<ProjectRolesEntity> projectRolesList;

    @Override
    public boolean equals(Object object) {
        if (object instanceof ProjectStructureEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
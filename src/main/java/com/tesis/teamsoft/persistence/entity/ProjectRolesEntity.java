package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project_roles")
public class ProjectRolesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectRolesSeq")
    @SequenceGenerator(name = "projectRolesSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Amount of workers role is required")
    @Column(name = "amount_workers_role", nullable = false)
    @Check(constraints = "amount_workers_role >= 1")
    private long amountWorkersRole;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectRoles", orphanRemoval = true)
    private List<ProjectTechCompetenceEntity> projectTechCompetenceList;

    @NotNull(message = "Project structure is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "project_structure_fk", nullable = false)
    private ProjectStructureEntity projectStructure;

    @NotNull(message = "Role is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_fk", nullable = false)
    private RoleEntity role;

    @NotNull(message = "Role load is required")
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_load_fk", nullable = false)
    private RoleLoadEntity roleLoad;

    @Override
    public boolean equals(Object object) {
        if (object instanceof ProjectRolesEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
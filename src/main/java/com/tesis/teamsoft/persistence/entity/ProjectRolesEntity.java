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
@Table(name = "project_roles")
public class ProjectRolesEntity implements Serializable {

    //Atributos
    //===================================================================================
    @Id//<--Marca el atributo como llave primaria de la entidad
    @Basic(optional = false)//<--Se utiliza para definir que un atributo es obligatorio y debe tener valor
    @NotNull//<--Se utiliza para especificar que un campo no puede ser null
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")//<--Indica que el valor de la llave primaria se genera automáticamente
    @SequenceGenerator(sequenceName = "hibernate_sequence", allocationSize = 1, name = "CUST_SEQ")//<--Se utiliza para definir un generador de secuencias
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "amount_workers_role")
    private long amountWorkersRole;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectRoles", orphanRemoval = true)
    private List<ProjectTechCompetenceEntity> projectTechCompetenceList;

    @JoinColumn(name = "project_structure_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProjectStructureEntity projectStructure;

    @JoinColumn(name = "role_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RoleEntity role;

    @JoinColumn(name = "role_load_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RoleLoadEntity roleLoad;
    //===================================================================================


    //Métodos
    //===================================================================================
    @Override
    public boolean equals(Object object) {
        if(object instanceof ProjectRolesEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    //===================================================================================
}

package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cycle")
public class CycleEntity implements Serializable {

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
    @Column(name = "begin_date")//<--Le asigna el nombre que tendra la columba en la base de datos
    @Temporal(TemporalType.DATE)//<--Indica que la variable sera de tipo fecha
    private Date beginDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)//<--Indica que la variable sera de tipo fecha
    private Date endDate;

    @JoinColumn(name = "project_fk", referencedColumnName = "id")//<--Establece la relacion con la clase ProjectEnitty
    @ManyToOne(optional = false)
    private ProjectEntity project;

    @JoinColumn(name = "project_structure_fk", referencedColumnName = "id")//<--Establece la relacion con la clase ProjectStructureEntity
    @ManyToOne(optional = false)
    private ProjectStructureEntity projectStructure;

    /*Se establece la relacion con AssignedRole(tabla y clase),
     a traves del atributo mapeado(cycles) en la clase AssignedRoleEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cycles")
    private List<AssignedRoleEntity> assignedRoleList;

    /*Se establece la relacion con ProjectRoleIncomp(tabla y clase),
     a traves del atributo mapeado(cycles) en la clase ProjectRoleIncompEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cycles")
    private List<ProjectRoleIncompEntity> projectRoleIncompList;

    /*Se establece la relacion con RolePersonEval(tabla y clase),
     a traves del atributo mapeado(cycles) en la clase RolePersonEvalEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cycles")
    private List<RolePersonEvalEntity> roleEvaluationList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cycle")
    private List<RoleEvalProjectEntity> roleEvalProjectList;
    //===================================================================================


    //Métodos
    //===================================================================================
    @Override
    public boolean equals(Object object) {
        if(object instanceof CycleEntity other) {
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

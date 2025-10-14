package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "project")
public class ProjectEntity implements Serializable {

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
    @Size(min = 1, max = 1024)//<--Restringe el tamaño del elemento, dandole mínimo y máximo
    @Column(name = "project_name")//<--Le asigna el nombre que tendra la columba en la base de datos
    private String projectName;

    @Basic(optional = false)
    @NotNull
    private boolean close;

    @Basic(optional = false)
    @NotNull
    @Column(name = "initial_date")
    @Temporal(TemporalType.DATE)//<--Indica que la variable sera de tipo fecha
    private Date initialDate;

    @Basic(optional = false)
    @NotNull
    private boolean finalize;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @JoinColumn(name = "client_entity_fk", referencedColumnName = "id")//<--Establece la relacion con la clase ClientEnitty
    @ManyToOne(optional = false)
    private ClientEntity client;

    @JoinColumn(name = "role_eval_fk", referencedColumnName = "id")//<--Establece la relacion con la clase RoleEvaluaEnitty
    @ManyToOne(optional = false)
    private RoleEvaluationEntity roleEvaluation;

    @JoinColumn(name = "province_fk", referencedColumnName = "id")//<--Establece la relacion con la clase CountyEnitty
    @ManyToOne(optional = false)
    private CountyEntity province;

    /*Se establece la relacion con Cycle(tabla y clase),
     a traves del atributo mapeado(project) en la clase CycleEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<CycleEntity> cycleList;

    /*Se establece la relacion con PersonalProjectInterest(tabla y clase),
     a traves del atributo mapeado(project) en la clase PersonalProjectInterestEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<PersonalProjectInterestsEntity> personalProjectInterestsList;
    //===================================================================================


    //Métodos
    //===================================================================================
    @Override
    public boolean equals(Object object) {
        if(object instanceof ProjectEntity other) {
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

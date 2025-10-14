package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "competence")
public class CompetenceEntity implements Serializable {

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
    @Column(name = "competition_name")//<--Le asigna el nombre que tendra la columba en la base de datos
    private String competitionName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    private String description;

    private Boolean technical;

    /*Se establece la relacion con RoleCompetition(tabla y clase),
     a traves del atributo mapeado(competence) en la clase RoleCompetitionEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competence")
    private List<RoleCompetitionEntity> roleCompetitionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competence")
    private List<ProjectTechCompetenceEntity> projectTechCompetenceList;

    /*Se establece la relacion con CompetenceValue(tabla y clase),
     a traves del atributo mapeado(competence) en la clase CompetenceValueEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competence")
    private List<CompetenceValueEntity> competenceValueList;

    /*Se establece la relacion con CompetenceDimensionEntity(tabla y clase),
     a traves del atributo mapeado(competence) en la clase CompetenceDimensionEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competence")
    private List<CompetenceDimensionEntity> competenceDimensionList;
    //===================================================================================


    //Métodos
    //===================================================================================
    @Override
    public boolean equals(Object object) {
        if(object instanceof CompetenceEntity other) {
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

package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "competence_importance")
public class CompetenceImportanceEntity implements Serializable {

    //Atributos
    //===================================================================================
    @Id//<--Marca el atributo como llave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")//<--Indica que el valor de la llave primaria se genera automáticamente
    @SequenceGenerator(sequenceName = "hibernate_sequence", allocationSize = 1, name = "CUST_SEQ")//<--Se utiliza para definir un generador de secuencias
    private Long id;

    @Basic(optional = false)
    @NotNull
    private long levels;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)//<--Restringe el tamaño del elemento, dandole mínimo y máximo
    private String significance;

    /*Se establece la relacion con RoleCompetition(tabla y clase),
     a traves del atributo mapeado(competenceImportance) en la clase RoleCompetitionEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competenceImportance")
    private List<RoleCompetitionEntity> roleCompetitionList;

//    /*Se establece la relacion con ProjectTechCompetence(tabla y clase),
//     a traves del atributo mapeado(competenceImportance) en la clase ProjectTechCompetenceEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competenceImportance")
    private List<ProjectTechCompetenceEntity> projectTechCompetenceList;
    //===================================================================================


    //Métodos
    //===================================================================================
    @Override
    public boolean equals(Object object) {
        if(object instanceof CompetenceImportanceEntity other) {
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

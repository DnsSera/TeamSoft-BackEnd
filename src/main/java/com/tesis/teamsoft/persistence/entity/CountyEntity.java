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
@Table(name = "county")
public class CountyEntity implements Serializable {

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
    @Column(name = "county_name")//<--Le asigna el nombre que tendra la columba en la base de datos
    private String countyName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    private String code;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "county")
//    private List<Municipality> municipalityList;

    /*Se establece la relacion con Projec(tabla y clase),
     a traves del atributo mapeado(province) en la clase ProjecEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "province")
    private List<ProjectEntity> projectList;

    /*Se establece la relacion con Person(tabla y clase),
     a traves del atributo mapeado(county) en la clase PersonEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "county")
    private List<PersonEntity> personList;

    /*Se establece la relacion con CostDistance(tabla y clase),
     a traves del atributo mapeado(countyA) en la clase CostDistanceEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countyA")
    private List<CostDistanceEntity> costDistanceListA;

    /*Se establece la relacion con CostDistance(tabla y clase),
     a traves del atributo mapeado(countyB) en la clase CostDistanceEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countyB")
    private List<CostDistanceEntity> costDistanceListB;
    //===================================================================================


    //Métodos
    //===================================================================================
    @Override
    public boolean equals(Object object) {
        if(object instanceof CountyEntity other) {
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

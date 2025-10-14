package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project_role_incomp")
public class ProjectRoleIncompEntity implements Serializable {

    //Atributos
    //===================================================================================
    @Id//<--Marca el atributo como llave primaria de la entidad
    @Basic(optional = false)//<--Se utiliza para definir que un atributo es obligatorio y debe tener valor
    @NotNull//<--Se utiliza para especificar que un campo no puede ser null
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")//<--Indica que el valor de la llave primaria se genera automáticamente
    @SequenceGenerator(sequenceName = "hibernate_sequence", allocationSize = 1, name = "CUST_SEQ")//<--Se utiliza para definir un generador de secuencias
    private Long id;

    @JoinColumn(name = "cycle_fk", referencedColumnName = "id")//<--Establece la relacion con la clase CycleEnitty
    @ManyToOne(optional = false)
    private CycleEntity cycles;

    @JoinColumn(name = "role_a_fk", referencedColumnName = "id")//<--Establece la relacion con la clase roleEnitty
    @ManyToOne(optional = false)
    private RoleEntity roleA;

    @JoinColumn(name = "role_b_fk", referencedColumnName = "id")//<--Establece la relacion con la clase RoleEnitty
    @ManyToOne(optional = false)
    private RoleEntity roleB;
    //===================================================================================


    //Métodos
    //===================================================================================
    @Override
    public boolean equals(Object object) {
        if(object instanceof ProjectRoleIncompEntity other) {
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

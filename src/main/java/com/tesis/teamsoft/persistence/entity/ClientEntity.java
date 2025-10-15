package com.tesis.teamsoft.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
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
@Table(name = "client")
public class ClientEntity implements Serializable {

    //Atributos
    //=====================================================================================================================
    @Id//<--Marca el atributo como llave primaria de la entidad
    @Basic(optional = false)//<--Se utiliza para definir que un atributo es obligatorio y debe tener valor
    @NotNull//<--Se utiliza para especificar que un campo no puede ser null
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")//<--Indica que el valor de la llave primaria se genera automáticamente
    @SequenceGenerator(sequenceName = "hibernate_sequence", allocationSize = 1, name = "CUST_SEQ")//<--Se utiliza para definir un generador de secuencias
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)//<--Restringe el tamaño del elemento, dandole mínimo y máximo
    @Column(name = "entity_name", unique = true)//<--Le asigna el nombre que tendra la columba en la base de datos
    private String entityName;//<--Establece que el atributo sera único

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    private String address;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    private String phone;

    /*Se establece la relacion con Project(tabla y clase),
     a traves del atributo mapeado(client) en la clase ProjectEntity*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<ProjectEntity> projectList;
    //=====================================================================================================================


    //Validaciones
    //=====================================================================================================================

    // Validación personalizada para el teléfono (más específica)
    @AssertTrue(message = "El teléfono debe contener al menos 8 dígitos numéricos")
    public boolean isPhoneValid() {
        if (phone == null) return false;
        String digitsOnly = phone.replaceAll("[^0-9]", "");
        return digitsOnly.length() >= 8;
    }

    // Validación para el nombre de entidad (evitar solo espacios)
    @AssertTrue(message = "El nombre de la entidad no puede contener solo espacios")
    public boolean isEntityNameValid() {
        return entityName != null && entityName.trim().length() > 0;
    }
    //=====================================================================================================================


    //Métodos
    //=====================================================================================================================
    @Override
    public boolean equals(Object object) {
        if(object instanceof ClientEntity other) {
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
    //=====================================================================================================================
}

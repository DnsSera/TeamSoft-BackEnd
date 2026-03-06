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
@Table(name = "client")
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientSeq")
    @SequenceGenerator(name = "clientSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "Entity name is required")
    @Column(name = "entity_name", nullable = false, unique = true)
    private String entityName;

    @NotNull(message = "Addres is required")
    @Column(nullable = false)
    private String address;

    @NotNull(message = "Phone is required")
    @Column(nullable = false)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<ProjectEntity> projectList;

    @Override
    public boolean equals(Object object) {
        if (object instanceof ClientEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
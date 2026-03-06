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
@Table(name = "county")
public class CountyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countySeq")
    @SequenceGenerator(name = "countySeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull(message = "County name is required")
    @Column(name = "county_name", nullable = false, unique = true)
    private String countyName;

    @NotNull(message = "Code is required")
    @Column(nullable = false, unique = true)
    private String code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "province")
    private List<ProjectEntity> projectList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "county")
    private List<PersonEntity> personList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countyA")
    private List<CostDistanceEntity> costDistanceListA;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countyB")
    private List<CostDistanceEntity> costDistanceListB;

    @Override
    public boolean equals(Object object) {
        if (object instanceof CountyEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
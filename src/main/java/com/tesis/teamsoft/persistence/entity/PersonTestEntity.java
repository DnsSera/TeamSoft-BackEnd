package com.tesis.teamsoft.persistence.entity;

import com.tesis.teamsoft.persistence.entity.auxiliary.BelbinRole;
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
@Table(name = "person_test")
public class PersonTestEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personTestSeq")
    @SequenceGenerator(name = "personTestSeq", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "e_s", nullable = false, length = 1)
    private BelbinRole eS;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "i_m", nullable = false, length = 1)
    private BelbinRole iM;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "c_o", nullable = false, length = 1)
    private BelbinRole cO;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "i_s", nullable = false, length = 1)
    private BelbinRole iS;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "c_e", nullable = false, length = 1)
    private BelbinRole cE;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "i_r", nullable = false, length = 1)
    private BelbinRole iR;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "m_e", nullable = false, length = 1)
    private BelbinRole mE;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "c_h", nullable = false, length = 1)
    private BelbinRole cH;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "i_f", nullable = false, length = 1)
    private BelbinRole iF;

    @NotNull(message = "MBTI result is required")
    @Column(name = "mbti_type", nullable = false)
    private String mbtiType;

    @NotNull(message = "Person is required")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_fk", nullable = false)
    private PersonEntity person;

    @Override
    public boolean equals(Object object) {
        if (object instanceof PersonTestEntity other) {
            return this.id != null && other.id != null && this.id.equals(other.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

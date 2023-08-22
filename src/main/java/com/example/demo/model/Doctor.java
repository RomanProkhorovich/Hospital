package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"full_name","specialization"}))
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(nullable = false,name = "full_name")
    private String fullName;

    @Range(min = 25, max = 85)
    @Column(nullable = false)
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return specialization == doctor.specialization && Objects.equals(fullName, doctor.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialization, fullName);
    }
}

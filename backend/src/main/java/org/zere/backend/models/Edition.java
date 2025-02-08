package org.zere.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Edition {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private int yearOfPublication;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
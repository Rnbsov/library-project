package org.zere.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Library {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments = new ArrayList<>();

    // Methods to add and remove departments
    public void addDepartment(Department department) {
        departments.add(department);
        department.setLibrary(this);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
        department.setLibrary(null);
    }
}
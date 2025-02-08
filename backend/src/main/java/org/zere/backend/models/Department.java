package org.zere.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Department {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genreName;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edition> editions = new ArrayList<>();

    // Methods to add and remove editions
    public void addEdition(Edition edition) {
        editions.add(edition);
        edition.setDepartment(this);
    }

    public void removeEdition(Edition edition) {
        editions.remove(edition);
        edition.setDepartment(null);
    }

    public int getNumberOfEditions() {
        return editions.size();
    }
}
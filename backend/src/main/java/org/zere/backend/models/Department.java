package org.zere.backend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genreName;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Edition> editions = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Edition> getEditions() {
        return editions;
    }

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
package org.zere.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zere.backend.models.Edition;

import java.util.List;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Long> {
    List<org.zere.backend.models.Edition> findByYearOfPublication(int year);
}
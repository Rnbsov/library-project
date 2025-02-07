package org.zere.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zere.backend.models.Edition;
import org.zere.backend.repositories.EditionRepository;

import java.util.List;

@Service
public class EditionService {

    @Autowired
    private EditionRepository editionRepository;

    public Edition createEdition(Edition edition) {
        return editionRepository.save(edition);
    }

    public Edition getEditionById(Long id) {
        return editionRepository.findById(id).orElse(null);
    }

    public List<Edition> getAllEditions() {
        return editionRepository.findAll();
    }

    public List<Edition> findEditionsByYear(int year) {
        return editionRepository.findByYearOfPublication(year);
    }

    public void deleteEdition(Long id) {
        editionRepository.deleteById(id);
    }
}
package org.zere.backend.services;

import org.zere.backend.models.Library;
import org.zere.backend.models.Edition;
import org.zere.backend.repository.LibraryRepository;
import org.zere.backend.repository.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private EditionRepository editionRepository;

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Library getLibraryById(Long id) {
        return libraryRepository.findById(id).orElse(null);
    }

    public List<Edition> findEditionsByYear(int year) {
        return editionRepository.findByYearOfPublication(year);
    }
}
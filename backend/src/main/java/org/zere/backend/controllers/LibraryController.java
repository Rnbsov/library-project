package org.zere.backend.controllers;

import org.zere.backend.models.Library;
import org.zere.backend.models.Edition;
import org.zere.backend.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return this.libraryService.createLibrary(library);
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable Long id) {
        return this.libraryService.getLibraryById(id);
    }

    @GetMapping("/editions/year/{year}")
    public List<Edition> findEditionsByYear(@PathVariable int year) {
        return this.libraryService.findEditionsByYear(year);
    }
}
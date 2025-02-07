package org.zere.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zere.backend.models.Edition;
import org.zere.backend.services.EditionService;

import java.util.List;

@RestController
@RequestMapping("/editions")
public class EditionController {

    @Autowired
    private EditionService editionService;

    @PostMapping
    public Edition createEdition(@RequestBody Edition edition) {
        return editionService.createEdition(edition);
    }

    @GetMapping("/{id}")
    public Edition getEditionById(@PathVariable Long id) {
        return editionService.getEditionById(id);
    }

    @GetMapping
    public List<Edition> getAllEditions() {
        return editionService.getAllEditions();
    }

    @GetMapping("/year/{year}")
    public List<Edition> findEditionsByYear(@PathVariable int year) {
        return editionService.findEditionsByYear(year);
    }

    @DeleteMapping("/{id}")
    public void deleteEdition(@PathVariable Long id) {
        editionService.deleteEdition(id);
    }
}
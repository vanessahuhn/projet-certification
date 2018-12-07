/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.controller;

import com.projet.model.Fixture;
import com.projet.service.FixtureService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vanessa
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/fixtures")
public class FixtureController {
    
    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private FixtureService service;

    @GetMapping
    List<Fixture> getAllFixtures() {
        return service.getAllFixtures();
    }

    /**
     * méthode READ pour toutes les instance de Fixture présentes dans notre
     * repository
     *
     * @return List<Fixture> via fixtureRepository.findAll()
     */
    @GetMapping("/{id}")
    ResponseEntity<Fixture> getFixtureById(@PathVariable(value = "id") long id) {
        Fixture fixture = service.getFixtureById(id);
        if (fixture == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(fixture);
    }
    
    @GetMapping("/last")
    List<Fixture> getLastFixtures() {
        return service.getLastFixtures();
    }

    @PostMapping
    Fixture addFixture(@Valid @RequestBody Fixture fixture) {        
        return service.addFixture(fixture);
    }

    @PutMapping("/{id}")
    ResponseEntity<Fixture> updateFixture(@PathVariable(value = "id") long id, @Valid @RequestBody Fixture fixture) {
        Fixture fixtureToUpdate = service.getFixtureById(id);
        if (fixtureToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        Fixture updatedFixture = service.updateFixture(fixtureToUpdate);
        return ResponseEntity.ok(updatedFixture);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Fixture> deleteFixture(@PathVariable(value = "id") long id) {
        Fixture fixture = service.getFixtureById(id);
        if (fixture == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteFixture(fixture);
        return ResponseEntity.ok().build();
    }

}

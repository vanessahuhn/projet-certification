/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.controller;

import com.projet.model.Equipe;
import com.projet.repository.EquipeRepository;
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
//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/equipe")
public class EquipeController {

    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private EquipeRepository equipeRepository;

    @GetMapping
    List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    /**
     * méthode READ pour toutes les instance de Equipe présentes dans notre
     * repository
     *
     * @return List<Equipe> via equipeRepository.findAll()
     */
    @GetMapping("{id}")
    ResponseEntity<Equipe> getEquipeById(@PathVariable(value = "id") long id) {
        Equipe equipe = equipeRepository.getOne(id);
        if (equipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(equipe);
    }

    @PostMapping
    Equipe addEquipe(@Valid @RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @PutMapping("/{id}")
    ResponseEntity<Equipe> updateEquipe(@PathVariable(value = "id") long id, @Valid @RequestBody Equipe equipe) {
        Equipe equipeToUpdate = equipeRepository.getOne(id);
        if (equipeToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        // Update all other not null attributes
        if (equipe.getNom() != null) {
            equipeToUpdate.setNom(equipe.getNom());
        }

        if (equipe.getPlace() != null) {
            equipeToUpdate.setPlace(equipe.getPlace());
        }

        if (equipe.getPoints() != null) {
            equipeToUpdate.setPoints(equipe.getPoints());
        }

        Equipe updatedEquipe = equipeRepository.save(equipeToUpdate);
        return ResponseEntity.ok(updatedEquipe);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Equipe> deleteEquipe(@PathVariable(value = "id") long id) {
        Equipe equipe = equipeRepository.getOne(id);
        if (equipe == null) {
            return ResponseEntity.notFound().build();
        }

        equipeRepository.delete(equipe);
        return ResponseEntity.ok().build();
    }

}

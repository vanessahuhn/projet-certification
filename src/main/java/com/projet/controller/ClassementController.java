/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.controller;

import com.projet.model.Classement;
import com.projet.repository.ClassementRepository;
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
@RequestMapping("/api/classement")
public class ClassementController {

    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private ClassementRepository classementRepository;

    @GetMapping
    List<Classement> getAllClassement() {
        return classementRepository.findAll();
    }

    /**
     * méthode READ pour toutes les instance de Classement présentes dans notre
     * repository
     *
     * @return List<Classement> via classementRepository.findAll()
     */
    @GetMapping("{id}")
    ResponseEntity<Classement> getClassementById(@PathVariable(value = "id") long id) {
        Classement classement = classementRepository.getOne(id);
        if (classement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(classement);
    }

    @PostMapping
    Classement addClassement(@Valid @RequestBody Classement classement) {
        return classementRepository.save(classement);
    }

    @PutMapping("/{id}")
    ResponseEntity<Classement> updateClassement(@PathVariable(value = "id") long id, @Valid @RequestBody Classement classement) {
        Classement classementToUpdate = classementRepository.getOne(id);
        if (classementToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        // Update all other not null attributes
        if (classement.getJournee() != null) {
            classementToUpdate.setJournee(classement.getJournee());
        }

        if (classement.getDateJournee() != null) {
            classementToUpdate.setDateJournee(classement.getDateJournee());
        }

        /*if (classement.getEquipes() != null) {
            classementToUpdate.setEquipes(classement.getEquipes());
        }*/

        Classement updatedClassement = classementRepository.save(classementToUpdate);
        return ResponseEntity.ok(updatedClassement);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Classement> deleteClassement(@PathVariable(value = "id") long id) {
        Classement classement = classementRepository.getOne(id);
        if (classement == null) {
            return ResponseEntity.notFound().build();
        }

        classementRepository.delete(classement);
        return ResponseEntity.ok().build();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.controller;

import com.projet.model.Match;
import com.projet.repository.MatchRepository;
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
@RequestMapping("/api/match")
public class MatchController {

    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private MatchRepository matchRepository;

    @GetMapping
    List<Match> getAllMatch() {
        return matchRepository.findAll();
    }

    /**
     * méthode READ pour toutes les instance de Match présentes dans notre
     * repository
     *
     * @return List<Match> via matchRepository.findAll()
     */
    @GetMapping("{id}")
    ResponseEntity<Match> getMatchById(@PathVariable(value = "id") long id) {
        Match match = matchRepository.getOne(id);
        if (match == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(match);
    }

    @PostMapping
    Match addMatch(@Valid @RequestBody Match match) {
        return matchRepository.save(match);
    }

    @PutMapping("/{id}")
    ResponseEntity<Match> updateMatch(@PathVariable(value = "id") long id, @Valid @RequestBody Match match) {
        Match matchToUpdate = matchRepository.getOne(id);
        if (matchToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        // Update all other not null attributes
        if (match.getDateMatch() != null) {
            matchToUpdate.setDateMatch(match.getDateMatch());
        }

        if (match.getEquipeDomicile() != null) {
            matchToUpdate.setEquipeDomicile(match.getEquipeDomicile());
        }

        if (match.getEquipeExterieur() != null) {
            matchToUpdate.setEquipeExterieur(match.getEquipeExterieur());
        }
        
        if (match.getButsDomicile() != null) {
            matchToUpdate.setButsDomicile(match.getButsDomicile());
        }
        
        if (match.getButsExterieur() != null) {
            matchToUpdate.setButsExterieur(match.getButsExterieur());
        }

        Match updatedMatch = matchRepository.save(matchToUpdate);
        return ResponseEntity.ok(updatedMatch);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Match> deleteMatch(@PathVariable(value = "id") long id) {
        Match match = matchRepository.getOne(id);
        if (match == null) {
            return ResponseEntity.notFound().build();
        }

        matchRepository.delete(match);
        return ResponseEntity.ok().build();
    }

}

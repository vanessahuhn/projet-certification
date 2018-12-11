/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.controller;

import com.projet.model.Ranking;
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
import com.projet.service.RankingService;

/**
 *
 * @author vanessa
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/ranking")
public class RankingController {

    @Autowired
    private RankingService service;

    @GetMapping
    List<Ranking> getAllRankings() {
        return service.getAllRankings();
    }

    /**
     * méthode READ pour toutes les instance de Ranking présentes dans notre
     * service
     *
     * @return List<Ranking> via service.findAll()
     */
    @GetMapping("{id}")
    ResponseEntity<Ranking> getRankingById(@PathVariable(value = "id") long id) {
        Ranking ranking = service.getRankingById(id);
        if (ranking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ranking);
    }

    @PostMapping
    Ranking addRanking(@Valid @RequestBody Ranking newRanking) {
        return service.addRanking(newRanking);
    }

    @PutMapping("/{id}")
    ResponseEntity<Ranking> updateRanking(@PathVariable(value = "id") long id, @Valid @RequestBody Ranking newRanking) {
        Ranking rankingToUpdate = service.getRankingById(id);
        if (rankingToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        rankingToUpdate = service.updateRanking(newRanking);
        return ResponseEntity.ok(rankingToUpdate);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Ranking> deleteRanking(@PathVariable(value = "id") long id) {
        Ranking ranking = service.getRankingById(id);
        if (ranking == null) {
            return ResponseEntity.notFound().build();
        }

        service.deleteRanking(ranking);
        return ResponseEntity.ok().build();
    }

}

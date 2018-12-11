/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.controller;

import com.projet.model.Team;
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
import com.projet.service.TeamService;

/**
 *
 * @author vanessa
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private TeamService service;

    @GetMapping
    List<Team> getAllTeams() {
        return service.getAllTeams();
    }

    /**
     * méthode READ pour toutes les instance de Team présentes dans notre
     * repository
     *
     * @return List<Team> via service.findAll()
     */
    @GetMapping("{id}")
    ResponseEntity<Team> getTeamById(@PathVariable(value = "id") long id) {
        Team team = service.getTeamById(id);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(team);
    }
    
    @GetMapping("/points")
    List<Team> getTeamByPoints() {
        return service.getTeamByPoints();
    }

    @PostMapping
    Team addTeam(@Valid @RequestBody Team newTeam) {
        return service.addTeam(newTeam);
    }

    @PutMapping("/{id}")
    ResponseEntity<Team> updateTeam(@PathVariable(value = "id") long id, @Valid @RequestBody Team newTeam) {
        Team teamToUpdate = service.getTeamById(id);
        if (teamToUpdate == null) {
            return ResponseEntity.notFound().build();
        }
        teamToUpdate = service.updateTeam(newTeam);
        return ResponseEntity.ok(teamToUpdate);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Team> deleteTeam(@PathVariable(value = "id") long id) {
        Team team = service.getTeamById(id);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }

        service.deleteTeam(team);
        return ResponseEntity.ok().build();
    }

}

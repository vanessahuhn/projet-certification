/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.service;

import com.projet.model.Team;
import com.projet.repository.TeamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vanessa
 */
@Service
public class TeamService {
    
    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private TeamRepository repository;
    
    public List<Team> getAllTeams() {
        return repository.findAll();
    }
    
    public Team getTeamById(long id) {
        Team team = repository.getOne(id);
        return team;
    }
    
    public List<Team> getTeamByPoints() {
        return repository.findByOrderByPointsDesc();
    }
    
    public Team addTeam(Team team) {
        return repository.save(team);
    }
    
    public Team updateTeam(Team team) {       
        Team updatedTeam = repository.save(team);
        return updatedTeam;
    }
    
    public Team deleteTeam(Team team) {
        repository.delete(team);
        return team;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.service;

import com.projet.model.Equipe;
import com.projet.model.Match;
import com.projet.repository.MatchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vanessa
 */
@Service
public class MatchService {

    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private MatchRepository matchRepository;

    public List<Match> getAllMatch() {
        return matchRepository.findAll();
    }

    public Match getMatchById(long id) {
        Match match = matchRepository.getOne(id);
        return match;
    }
    
    public List<Match> getLastMatches() {
        return matchRepository.findTop2ByOrderByMatchIdDesc();
    }
    
    public Match addMatch(Match match) {        
        return matchRepository.save(match);
    }
    
    public Match updateMatch(Match match) {       
        Match updatedMatch = matchRepository.save(match);
        return updatedMatch;
    }
    
    public Match deleteMatch(Match match) {
        matchRepository.delete(match);
        return match;
    }
}

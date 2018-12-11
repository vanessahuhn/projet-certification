/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.service;

import com.projet.model.Ranking;
import com.projet.repository.RankingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vanessa
 */
@Service
public class RankingService {
    
    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private RankingRepository repository;
    
    public List<Ranking> getAllRankings() {
        return repository.findAll();
    }

    public Ranking getRankingById(long id) {
        Ranking ranking = repository.getOne(id);        
        return ranking;
    }

    public Ranking addRanking(Ranking newRanking) {
        return repository.save(newRanking);
    }

    public Ranking updateRanking(Ranking newRanking) {
        return repository.save(newRanking);
    }

    public Ranking deleteRanking(Ranking ranking) {
        repository.delete(ranking);
        return ranking;
    }    
}

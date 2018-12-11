/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.service;

import com.projet.model.Fixture;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projet.repository.FixtureRepository;

/**
 *
 * @author vanessa
 */
@Service
public class FixtureService {

    //permet d'injecter LinkRepository dans mon contrôleur
    @Autowired
    //je créé une instance de LinkRepository
    private FixtureRepository repository;

    public List<Fixture> getAllFixtures() {
        return repository.findAll();
    }

    public Fixture getFixtureById(long id) {
        Fixture fixture = repository.getOne(id);
        return fixture;
    }
    
    public List<Fixture> getLastFixtures() {
        return repository.findTop2ByOrderByFixtureIdDesc();
    }
    
    public Fixture addFixture(Fixture newFixture) {        
        return repository.save(newFixture);
    }
    
    public Fixture updateFixture(Fixture newFixture) {       
        return repository.save(newFixture);
    }
    
    public Fixture deleteFixture(Fixture fixture) {
        repository.delete(fixture);
        return fixture;
    }
}

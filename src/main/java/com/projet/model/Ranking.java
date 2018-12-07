/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vanessa
 */
@Entity
public class Ranking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long standingId;
    
    private Integer round;
    
    public String evolution;
    
    @OneToMany (mappedBy = "classement")
    private List<Team> equipes;
    
    public Ranking() {
    }

    public Ranking(Long standingId, Integer round, String evolution, List<Team> equipes) {
        this.standingId = standingId;
        this.round = round;
        this.evolution = evolution;
        this.equipes = equipes;
    }

    public Long getStandingId() {
        return standingId;
    }

    public void setStandingId(Long standingId) {
        this.standingId = standingId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public List<Team> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Team> equipes) {
        this.equipes = equipes;
    }

        
    
}

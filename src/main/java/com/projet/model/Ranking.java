/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.model;


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
    private Long rankingId;
    
    private Integer round;
    
    private String evolution;
    
    @OneToMany
    private List<Team> teams;
    
    public Ranking() {
    }

    public Ranking(Long rankingId, Integer round, String evolution, List<Team> teams) {
        this.rankingId = rankingId;
        this.round = round;
        this.evolution = evolution;
        this.teams = teams;
    }

    public Long getRankingId() {
        return rankingId;
    }

    public void setRankingId(Long rankingId) {
        this.rankingId = rankingId;
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

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

        
    
}

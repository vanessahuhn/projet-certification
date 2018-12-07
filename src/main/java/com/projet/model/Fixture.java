/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.model;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author vanessa
 */
@Entity
public class Fixture {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fixtureId;
    
    //date était un mot réservé
    private LocalDate eventDate;
     
    @ManyToOne
    private Team homeTeam;    
    
    @ManyToOne
    private Team awayTeam;
    
    //j'ai choisi le type Integer pour pouvoir vérifier si l'utilisateur a entré une valeur ou pas
    private Integer goalsHomeTeam;
    
    private Integer goalsAwayTeam;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name = "Equipe_Match", 
        joinColumns = { @JoinColumn(name = "match_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "equipe_id") }
    )
    private List<Team> equipes;

    public Fixture() {
    }

    public Fixture(Long fixtureId, LocalDate eventDate, Team homeTeam, Team awayTeam, Integer goalsHomeTeam, Integer goalsAwayTeam, List<Team> equipes) {
        this.fixtureId = fixtureId;
        this.eventDate = eventDate;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
        this.equipes = equipes;
    }

    public Long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Integer goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Integer getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Integer goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public List<Team> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Team> equipes) {
        this.equipes = equipes;
    }
    
    

    

    
      
}

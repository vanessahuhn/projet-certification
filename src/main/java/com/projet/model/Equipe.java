/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author vanessa
 */
@Entity
public class Equipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long equipeId;
    
    private String nom;
    
    private Integer place;
    
    private Integer points;
    
    private String logo;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "equipes")
    private List<Match> matchs;
    
    @ManyToOne
    private Classement classement;

    public Equipe() {
    }

    public Equipe(Long equipeId, String nom, Integer place, Integer points, String logo, List<Match> matchs, Classement classement) {
        this.equipeId = equipeId;
        this.nom = nom;
        this.place = place;
        this.points = points;
        this.logo = logo;
        this.matchs = matchs;
        this.classement = classement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Long equipeId) {
        this.equipeId = equipeId;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Classement getClassement() {
        return classement;
    }

    public void setClassement(Classement classement) {
        this.classement = classement;
    }
    
    
    
}

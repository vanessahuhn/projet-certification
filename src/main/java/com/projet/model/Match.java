/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author vanessa
 */
@Entity
@Table(name="matchFoot")
public class Match {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchId;
    
    //date était un mot réservé
    private LocalDate dateMatch;
            
    @OneToOne
    private Equipe equipeDomicile;
        
    @OneToOne
    private Equipe equipeExterieur;
    
    //j'ai choisi le type Integer pour pouvoir vérifier si l'utilisateur a entré une valeur ou pas
    private Integer butsDomicile;
    
    private Integer butsExterieur;
    
    private String logoDomicile;
    
    private String logoExterieur;
    
    @ManyToMany
    @JoinTable(
        name = "Equipe_Match", 
        joinColumns = { @JoinColumn(name = "match_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "equipe_id") }
    )
    private List<Equipe> equipes;

    public Match() {
    }

    public Match(Long id, LocalDate dateMatch, Equipe equipeDomicile, Equipe equipeExterieur, Integer butsDomicile, Integer butsExterieur, String logoDomicile, String logoExterieur) {
        this.matchId = id;
        this.dateMatch = dateMatch;
        this.equipeDomicile = equipeDomicile;
        this.equipeExterieur = equipeExterieur;
        this.butsDomicile = butsDomicile;
        this.butsExterieur = butsExterieur;
        this.logoDomicile = logoDomicile;
        this.logoExterieur = logoExterieur;
    }

    public Equipe getEquipeDomicile() {
        return equipeDomicile;
    }

    public void setEquipeDomicile(Equipe equipeDomicile) {
        this.equipeDomicile = equipeDomicile;
    }

    public Equipe getEquipeExterieur() {
        return equipeExterieur;
    }

    public void setEquipeExterieur(Equipe equipeExterieur) {
        this.equipeExterieur = equipeExterieur;
    }

    public Integer getButsDomicile() {
        return butsDomicile;
    }

    public void setButsDomicile(Integer butsDomicile) {
        this.butsDomicile = butsDomicile;
    }

    public Integer getButsExterieur() {
        return butsExterieur;
    }

    public void setButsExterieur(Integer butsExterieur) {
        this.butsExterieur = butsExterieur;
    }

    public LocalDate getDateMatch() {
        return dateMatch;
    }

    public void setDateMatch(LocalDate dateMatch) {
        this.dateMatch = dateMatch;
    }

    public String getLogoDomicile() {
        return logoDomicile;
    }

    public void setLogoDomicile(String logoDomicile) {
        this.logoDomicile = logoDomicile;
    }

    public String getLogoExterieur() {
        return logoExterieur;
    }

    public void setLogoExterieur(String logoExterieur) {
        this.logoExterieur = logoExterieur;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    
      
}

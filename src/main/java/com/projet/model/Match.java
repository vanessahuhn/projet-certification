/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.model;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author vanessa
 */
@Entity
public class Match {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //date était un mot réservé
    private LocalDate dateMatch;
    
    private String equipeDomicile;
    
    private String equipeExterieur;
    
    //j'ai choisi le type Integer pour pouvoir vérifier si l'utilisateur a entré une valeur ou pas
    private Integer butsDomicile;
    
    private Integer butsExterieur;
    
    private String logoDomicile;
    
    private String logoExterieur;

    public Match() {
    }

    public Match(Long id, LocalDate dateMatch, String equipeDomicile, String equipeExterieur, Integer butsDomicile, Integer butsExterieur, String logoDomicile, String logoExterieur) {
        this.id = id;
        this.dateMatch = dateMatch;
        this.equipeDomicile = equipeDomicile;
        this.equipeExterieur = equipeExterieur;
        this.butsDomicile = butsDomicile;
        this.butsExterieur = butsExterieur;
        this.logoDomicile = logoDomicile;
        this.logoExterieur = logoExterieur;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipeDomicile() {
        return equipeDomicile;
    }

    public void setEquipeDomicile(String equipeDomicile) {
        this.equipeDomicile = equipeDomicile;
    }

    public String getEquipeExterieur() {
        return equipeExterieur;
    }

    public void setEquipeExterieur(String equipeExterieur) {
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
      
}

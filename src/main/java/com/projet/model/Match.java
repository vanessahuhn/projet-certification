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

    public Match() {
    }

    public Match(Long id, LocalDate date, String equipeDomicile, String equipeExterieur, int butsDomicile, int butsExterieur) {
        this.id = id;
        this.dateMatch = date;
        this.equipeDomicile = equipeDomicile;
        this.equipeExterieur = equipeExterieur;
        this.butsDomicile = butsDomicile;
        this.butsExterieur = butsExterieur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return dateMatch;
    }

    public void setDate(LocalDate dateMatch) {
        this.dateMatch = dateMatch;
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
      
}

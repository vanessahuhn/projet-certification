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
public class Classement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Integer journee;
    
    private LocalDate dateJournee;
    
    @OneToMany (mappedBy = "classement")
    private List<Equipe> equipes;
    
    //private List<Equipe> equipes;

    public Classement() {
    }

    public Classement(Long id, Integer journee, LocalDate dateJournee) {
        this.id = id;
        this.journee = journee;
        this.dateJournee = dateJournee;
        //this.equipes = equipes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getJournee() {
        return journee;
    }

    public void setJournee(Integer journee) {
        this.journee = journee;
    }

    public LocalDate getDateJournee() {
        return dateJournee;
    }

    public void setDateJournee(LocalDate dateJournee) {
        this.dateJournee = dateJournee;
    }    
    
}

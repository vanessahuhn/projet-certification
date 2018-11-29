/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projet.service;

import com.projet.model.Equipe;
import com.projet.model.Match;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author vanessa
 */
@Service
public class MatchService {
    
    public void setTeams(Match match, List<Equipe> equipes) {
        for (Equipe equipe : equipes) {
            if (equipes.indexOf(equipe) % 2 == 0)
            {
                match.setEquipeDomicile(equipe);
            }
            else {
                match.setEquipeExterieur(equipe);
            }
        }
    }
    
    public void setPoints(Match match, Equipe equipeDomicile, Equipe equipeExterieur) {

        if (match.getButsDomicile() > match.getButsExterieur()){
            equipeDomicile.setPoints(equipeDomicile.getPoints() + 3);
        }
        else if (match.getButsDomicile() < match.getButsExterieur()){
            equipeExterieur.setPoints(equipeExterieur.getPoints() + 3);
        }
        else {
            equipeDomicile.setPoints(equipeDomicile.getPoints() + 1);
            equipeExterieur.setPoints(equipeExterieur.getPoints() + 1);
        }
                
    }
    
}

import { Injectable } from '@angular/core';
import { Match } from '../model/match';
import { Equipe } from '../model/equipe';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

public setTeams(match: Match, equipes: Equipe[]){

for (let equipe of equipes){
      if (equipes.indexOf(equipe) % 2 === 0) {
        match.equipeDomicile = equipe;
      }
      else {
        match.equipeExterieur = equipe;
      }
      }
}

public setPoints(match: Match, equipeDomicile: Equipe, equipeExterieur: Equipe) {
    if (match.butsDomicile > match.butsExterieur) {
        equipeDomicile.points += 3;
    }
    else if (match.butsDomicile < match.butsExterieur) {
        equipeExterieur.points += 3;
    }
    else {
        equipeDomicile.points ++;
        equipeExterieur.points ++;
    }
}
  constructor() { }
}

import { Injectable } from '@angular/core';
import { Match } from '../model/match';
import { Equipe } from '../model/equipe';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

public setPoints(match: Match, equipeDomicile: Equipe, equipeExterieur: Equipe) {
    if (match.butsDomicile > match.butsExterieur) {
        equipeDomicile.points += 3;
    }
    else if (match.butsDomicile < match.butsExterieur) {
        equipeExterieur.points += 3;
    }
    else {
        equipeDomicile.points += 1;
        equipeExterieur.points += 1;
    }
}
  constructor() { }
}

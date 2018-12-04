import { Injectable } from '@angular/core';
import { Equipe } from '../model/equipe';

@Injectable({
  providedIn: 'root'
})
export class EquipeService {

public setPlace(equipes : Equipes[]) {
for (let equipe of equipes){
    equipe.place = equipes.indexOf(equipe) + 1;
    }
}

  constructor() { }
}

import { Equipe } from './equipe';

export class Match {

matchId : number;
dateMatch : Date;
equipeDomicile : Equipe;
equipeExterieur : Equipe;
butsDomicile : number;
butsExterieur : number;
equipes : Equipe[];
  
}

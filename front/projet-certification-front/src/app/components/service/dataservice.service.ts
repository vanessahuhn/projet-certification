import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Match } from '../model/match';
import { Equipe } from '../model/equipe';
import { MatchService } from './match.service';


@Injectable({
  providedIn: 'root'
})
export class DataserviceService {

  constructor(private httpClient : HttpClient, private matchService: MatchService) { }
  
  public getLastMatches() : Observable<Match[]> {
    return this.httpClient.get<Match[]>('http://localhost:8080/api/match/last');
  }
  
  public addMatch (match: Match): Observable<Match> {
      this.matchService.setTeams(match, match.equipes);
      this.matchService.setPoints(match, match.equipeDomicile, match.equipeExterieur);
      this.addEquipe(match.equipeDomicile);
      this.addEquipe(match.equipeExterieur);
      return this.httpClient.post<Match>('http://localhost:8080/api/match', match);
    }
          
  public addEquipe (equipe: Equipe): Observable<Equipe> {
      return this.httpClient.post<Equipe>('http://localhost:8080/api/equipe', equipe);
  }
  
  
}

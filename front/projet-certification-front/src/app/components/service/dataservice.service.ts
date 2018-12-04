import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Match } from '../model/match';
import { Equipe } from '../model/equipe';
import { MatchService } from './match.service';
import { EquipeService } from './equipe.service';


@Injectable({
  providedIn: 'root'
})
export class DataserviceService {

  constructor(private httpClient : HttpClient, private matchService: MatchService, private equipeService: EquipeService) { }
  
  public getAllMatches() : Observable<Match[]> {
    return this.httpClient.get<Match[]>('http://localhost:8080/api/match');
  }
  
  public getLastMatches() : Observable<Match[]> {
    return this.httpClient.get<Match[]>('http://localhost:8080/api/match/last');
  }
  
  public addMatch (match: Match): Observable<Match> {
      this.matchService.setPoints(match, match.equipeDomicile, match.equipeExterieur);
      
      return this.httpClient.post<Match>('http://localhost:8080/api/match', match);
    }
          
  public getEquipes() : Observable<Equipe[]> {return this.httpClient.get<Equipe[]>('http://localhost:8080/api/equipe');
          }
          
          public getEquipesByPoints() : Observable<Equipe[]> {return this.httpClient.get<Equipe[]>('http://localhost:8080/api/equipe/points');
          }
  public addEquipe (equipe: Equipe): Observable<Equipe> {
      return this.httpClient.post<Equipe>('http://localhost:8080/api/equipe', equipe);
  }
          
          public updateEquipe (equipe: Equipe): Observable<Equipe> {
              this.equipeService.setPlace(this.getEquipes());
      return this.httpClient.put<Equipe>('http://localhost:8080/api/equipe' + '/' + equipe.equipeId, equipe);
    }
  
  
}

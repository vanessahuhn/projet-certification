import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Team } from '../model/team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private httpClient : HttpClient) {}

    public setRankingPosition(teams : Team[]) {
      for (let team of teams){
          team.rankingPosition = teams.indexOf(team) + 1;
      }
    }

    public getTeams() : Observable<Team[]> {
      return this.httpClient.get<Team[]>('http://localhost:8080/api/teams');
    }

    public getTeamsByPoints() : Observable<Team[]> {
      return this.httpClient.get<Team[]>('http://localhost:8080/api/teams/points');
    }
    public addTeam (team: Team): Observable<Team> {
      return this.httpClient.post<Team>('http://localhost:8080/api/teams', team);
    }
            
    public updateTeam (team: Team): Observable<Team> {
      //this.teamService.setRankingPosition(this.getTeams());
      return this.httpClient.put<Team>('http://localhost:8080/api/teams' + '/' + team.teamId, team);
    }  
}

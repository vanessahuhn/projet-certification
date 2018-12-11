import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fixture } from '../model/fixture';
import { Team } from '../model/team';

@Injectable({
  providedIn: 'root'
})
export class FixtureService {

    constructor(private httpClient : HttpClient) {}

        public getAllFixtures() : Observable<Fixture[]> {
            return this.httpClient.get<Fixture[]>('http://localhost:8080/api/fixtures');
          }

        public getLastFixtures() : Observable<Fixture[]> {
        return this.httpClient.get<Fixture[]>('http://localhost:8080/api/fixtures/last');
        }

        public addFixture (fixture: Fixture): Observable<Fixture> {
            this.setPoints(fixture, fixture.homeTeam, fixture.awayTeam);     
            return this.httpClient.post<Fixture>('http://localhost:8080/api/fixtures', fixture);
          }

        public setPoints(fixture: Fixture, homeTeam: Team, awayTeam: Team) {
        if (fixture.goalsHomeTeam > fixture.goalsAwayTeam) {
            homeTeam.points += 3;
        }
        else if (fixture.goalsHomeTeam < fixture.goalsAwayTeam) {
            awayTeam.points += 3;
        }
        else {
            homeTeam.points += 1;
            awayTeam.points += 1;
        }
        
    }


  
}

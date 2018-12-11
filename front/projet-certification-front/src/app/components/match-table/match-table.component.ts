import { Component, OnInit } from '@angular/core';
import { Fixture } from '../model/fixture';
import { Team } from '../model/team';
import { TeamService } from '../service/team.service';
import { FixtureService } from '../service/fixture.service';

@Component({
  selector: 'app-match-table',
  templateUrl: './match-table.component.html',
  styleUrls: ['./match-table.component.scss']
})
export class MatchTableComponent implements OnInit {

    fixtures : Fixture[];
    teams : Team[];
    fixture = new Fixture();

  constructor(private teamService : TeamService, private fixtureService : FixtureService) { }

  ngOnInit() {
  this.fixtureService.getLastFixtures().subscribe( fixtures => this.fixtures = fixtures); 
  this.teamService.getTeams().subscribe( teams => this.teams = teams);
  }
  
  newFixture() {
    this.fixtureService.addFixture(this.fixture).subscribe(fixture => this.fixtures.push(fixture));
    this.teamService.updateTeam(this.fixture.homeTeam).subscribe(team => this.teams.push(team));
    this.teamService.updateTeam(this.fixture.awayTeam).subscribe(team => this.teams.push(team));
  }

}

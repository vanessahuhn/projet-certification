import { Component, OnInit } from '@angular/core';
import { Fixture } from '../model/fixture';
import { Team } from '../model/team';
import { TeamService } from '../service/team.service';
import { FixtureService } from '../service/fixture.service';

@Component({
  selector: 'app-derniers-matchs',
  templateUrl: './derniers-matchs.component.html',
  styleUrls: ['./derniers-matchs.component.scss']
})
export class DerniersMatchsComponent implements OnInit {

  fixtures : Fixture[];
  teams : Team[];

  constructor(private teamService : TeamService, private fixtureService : FixtureService) { }

  ngOnInit() {
  this.teamService.getTeams().subscribe( teams => this.teams = teams);
  this.fixtureService.getLastFixtures().subscribe( fixtures => this.fixtures = fixtures);  
  }

}

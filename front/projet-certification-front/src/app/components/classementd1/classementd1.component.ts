import { Component, OnInit } from '@angular/core';
import { Team } from '../model/team';
import { TeamService } from '../service/team.service';

@Component({
  selector: 'app-classementd1',
  templateUrl: './classementd1.component.html',
  styleUrls: ['./classementd1.component.scss']
})
export class Classementd1Component implements OnInit {

    teams : Team[];

  constructor(private teamService : TeamService) { }

  ngOnInit() {
  this.teamService.getTeamsByPoints().subscribe( teams => this.teams = teams);
  }

}

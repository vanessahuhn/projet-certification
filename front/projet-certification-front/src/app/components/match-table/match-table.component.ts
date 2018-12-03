import { Component, OnInit } from '@angular/core';
import { Match } from '../model/match';
import { Equipe } from '../model/equipe';
import { DataserviceService } from '../service/dataservice.service';

@Component({
  selector: 'app-match-table',
  templateUrl: './match-table.component.html',
  styleUrls: ['./match-table.component.scss']
})
export class MatchTableComponent implements OnInit {

    matchs : Match[];
    equipes : Equipe[];
    match = new Match();

  constructor(private dataService : DataserviceService) { }

  ngOnInit() {
  this.dataService.getLastMatches().subscribe( matchs => this.matchs = matchs);
  this.dataService.getEquipes().subscribe( equipes => this.equipes = equipes);
  }
  
  newMatch() {
    this.dataService.addMatch(this.match).subscribe(match => this.matchs.push(match));
  }

}

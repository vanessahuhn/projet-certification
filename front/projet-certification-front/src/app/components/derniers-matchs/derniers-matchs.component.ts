import { Component, OnInit } from '@angular/core';
import { Match } from '../model/match';
import { DataserviceService } from '../service/dataservice.service';

@Component({
  selector: 'app-derniers-matchs',
  templateUrl: './derniers-matchs.component.html',
  styleUrls: ['./derniers-matchs.component.scss']
})
export class DerniersMatchsComponent implements OnInit {

  matchs : Match[];

  constructor(private dataService : DataserviceService) { }

  ngOnInit() {
  this.dataService.getLastMatches().subscribe( matchs => this.matchs = matchs);
  }

}

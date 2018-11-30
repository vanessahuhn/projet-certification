import { Component, OnInit } from '@angular/core';
import { Equipe } from '../model/equipe';
import { DataserviceService } from '../service/dataservice.service';

@Component({
  selector: 'app-classementd1',
  templateUrl: './classementd1.component.html',
  styleUrls: ['./classementd1.component.scss']
})
export class Classementd1Component implements OnInit {

    equipes : Equipe[];

  constructor(private dataService : DataserviceService) { }

  ngOnInit() {
  this.dataService.getEquipesByPoints().subscribe( equipes => this.equipes = equipes);
  }

}

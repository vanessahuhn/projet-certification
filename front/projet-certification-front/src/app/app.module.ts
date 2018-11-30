import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { DerniersMatchsComponent } from './components/derniers-matchs/derniers-matchs.component';
import { Classementd1Component } from './components/classementd1/classementd1.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MatchTableComponent } from './components/match-table/match-table.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DerniersMatchsComponent,
    Classementd1Component,
    DashboardComponent,
    MatchTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),    
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

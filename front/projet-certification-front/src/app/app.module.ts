import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { DerniersMatchsComponent } from './components/derniers-matchs/derniers-matchs.component';
import { Classementd1Component } from './components/classementd1/classementd1.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DerniersMatchsComponent,
    Classementd1Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
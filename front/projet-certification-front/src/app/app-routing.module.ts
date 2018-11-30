import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent }   from './components/dashboard/dashboard.component';
import { DerniersMatchsComponent } from './components/derniers-matchs/derniers-matchs.component';
import { Classementd1Component } from './components/classementd1/classementd1.component';

const routes: Routes = [{ path: '', component: DerniersMatchsComponent }, { path: 'dashboard', component: DashboardComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

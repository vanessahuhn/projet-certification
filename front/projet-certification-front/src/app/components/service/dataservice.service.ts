import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Match } from '../model/match';

@Injectable({
  providedIn: 'root'
})
export class DataserviceService {

  constructor(private httpClient : HttpClient) { }
  
  public getAllMatch() : Observable<Match[]> {
    return this.httpClient.get<Match[]>('http://localhost:8080/api/match');
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Outcomes } from '../models/outcomes.model';

@Injectable({
  providedIn: 'root'
})
export class OutcomeService {

  constructor(private http: HttpClient) { }

  getAllOutcomes(): Observable<Outcomes[]>{
    return this.http.get<Outcomes[]>(`${environment.apiUrl}outcomes`);
  }

  createOutcome(outcome:Outcomes): Observable<{}>{
    return this.http.post(`${environment.apiUrl}outcomes`,outcome);
  }
}

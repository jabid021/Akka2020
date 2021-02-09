import { Personne } from './../model/personne';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PersonneService {
  private url: string = 'http://localhost:8080/monsite/api/personne';

  constructor(private http: HttpClient) {}

  public allPersonne(): Observable<Personne> {
    return this.http.get<Personne>(this.url);
  }
}

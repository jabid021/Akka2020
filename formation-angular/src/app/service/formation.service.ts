import { HttpClient } from '@angular/common/http';
import { Formation } from './../model/formation';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FormationService {
  url: string = 'http://localhost:3000/formation';

  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<Formation[]> {
    return this.httpClient.get<Formation[]>(this.url);
  }

  public findById(id: number): Observable<Formation> {
    return this.httpClient.get<Formation>(`${this.url}/${id}`);
  }

  public insert(formation: Formation): Observable<Formation> {
    const f = {
      nom: formation.nom,
      duree: formation.duree,
    };
    return this.httpClient.post<Formation>(this.url, f);
  }

  public update(formation: Formation): Observable<Formation> {
    return this.httpClient.put<Formation>(
      `${this.url}/${formation.id}`,
      formation
    );
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.url}/${id}`);
  }
}

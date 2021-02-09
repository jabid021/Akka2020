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

  public allPersonne(): Observable<Personne[]> {
    return this.http.get<Personne[]>(this.url);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id);
  }

  public update(personne: Personne): Observable<Personne> {
    return this.http.put<Personne>(`${this.url}/${personne.id}`, personne);
  }

  public insert(personne: Personne): Observable<Personne> {
    const o = {
      prenom: personne.prenom,
      nom: personne.nom,
    };
    return this.http.post<Personne>(this.url, o);
  }
}

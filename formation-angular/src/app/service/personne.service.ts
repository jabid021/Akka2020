import { Personne } from './../model/personne';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PersonneService {
  private url: string = 'http://localhost:8080/monsite/api/personne';

  private httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa('olivier:olivier'),
    });
  }

  public allPersonne(): Observable<Personne[]> {
    return this.http.get<Personne[]>(this.url, { headers: this.httpHeaders });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public update(personne: Personne): Observable<Personne> {
    return this.http.put<Personne>(`${this.url}/${personne.id}`, personne, {
      headers: this.httpHeaders,
    });
  }

  public insert(personne: Personne): Observable<Personne> {
    const o = {
      prenom: personne.prenom,
      nom: personne.nom,
    };
    return this.http.post<Personne>(this.url, o, { headers: this.httpHeaders });
  }
}

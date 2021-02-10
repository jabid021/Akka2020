import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root',
})
export class InscriptionService {
  private url: string = 'http://localhost:8080/monsite/api/inscription';

  constructor(private http: HttpClient) {}

  public insciption(login: Login): Observable<void> {
    const user = {
      login: login.username,
      password: login.password,
    };
    return this.http.post<void>(this.url, user);
  }

  public checkLogin(username: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.url}/${username}`);
  }
}

import { Router } from '@angular/router';
import { LoginService } from './../service/login.service';
import { Component, OnInit } from '@angular/core';
import { Login } from '../model/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: Login = new Login();
  erreur: boolean = false;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  public send() {
    this.loginService.auth(this.login).subscribe(
      (result) => {
        sessionStorage.setItem(
          'tokenId',
          btoa(`${this.login.username}:${this.login.password}`)
        );
        sessionStorage.setItem('login', this.login.username);
        this.router.navigate(['/home']);
      },
      (error) => {
        this.erreur = true;
      }
    );
  }
}

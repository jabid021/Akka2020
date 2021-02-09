import { Component, OnInit } from '@angular/core';
import { Login } from '../model/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  login: Login = new Login();

  constructor() {}

  ngOnInit(): void {}

  public send() {}
}

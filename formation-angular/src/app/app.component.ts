import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { Client } from 'src/model/client';
import { Produit } from 'src/model/produit';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  user: string = sessionStorage.getItem('login');

  constructor(private router: Router) {}

  public logout() {
    sessionStorage.removeItem('tokenId');
    sessionStorage.removeItem('login');
    this.user = '';
    this.router.navigate(['/home']);
  }
}

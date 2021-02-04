import { Component } from '@angular/core';
import { Client } from 'src/model/client';
import { Produit } from 'src/model/produit';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'formation-angular';
  couleur = 'blue';

  produit: Produit = new Produit();

  public visible(): boolean {
    return this.produit.nom !== '' && this.produit.prix !== 0;
  }
}

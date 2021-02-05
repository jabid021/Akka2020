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
  nomTop: string = 'aucun';
  nombreTop: number = 0;

  public visible(): boolean {
    return this.produit.nom !== '' && this.produit.prix !== 0;
  }

  public produitFactory(nom: string, prix: number): Produit {
    return new Produit(nom, prix);
  }

  public gestionCommande(input) {
    if (input.nbreCommande > this.nombreTop) {
      this.nomTop = input.produit.nom;
      this.nombreTop = input.nbreCommande;
    }
  }

  public recuperationProduit(produit: Produit) {
    this.produit = produit;
  }
}

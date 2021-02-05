import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Produit } from 'src/model/produit';

@Component({
  selector: 'saisie-produit',
  templateUrl: './saisie-produit.component.html',
  styleUrls: ['./saisie-produit.component.css'],
})
export class SaisieProduitComponent implements OnInit {
  produit: Produit = new Produit();
  @Output()
  produitEnregistre: EventEmitter<Produit> = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  public save() {
    this.produitEnregistre.emit(this.produit);
    this.produit = new Produit();
  }
}

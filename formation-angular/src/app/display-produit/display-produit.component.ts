import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { Produit } from 'src/model/produit';

@Component({
  selector: 'display-produit',
  templateUrl: './display-produit.component.html',
  styleUrls: ['./display-produit.component.css'],
})
export class DisplayProduitComponent implements OnInit {
  @Input()
  produit: Produit;
  @Output()
  commande: EventEmitter<Object> = new EventEmitter();
  nbreCommande: number = 0;

  constructor() {}

  ngOnInit(): void {}

  public commander() {
    this.nbreCommande++;
    this.commande.emit({
      produit: this.produit,
      nbreCommande: this.nbreCommande,
    });
  }
}

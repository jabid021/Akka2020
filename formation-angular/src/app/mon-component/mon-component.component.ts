import { Component, HostListener, OnInit } from '@angular/core';
import { Produit } from 'src/model/produit';

@Component({
  selector: 'mon-component',
  templateUrl: './mon-component.component.html',
  styleUrls: ['./mon-component.component.css'],
})
export class MonComponentComponent implements OnInit {
  variableDansMonComponent = 'hello world';
  recupEvent: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  public click() {
    console.log('click sur le bouton');
  }

  @HostListener('click')
  public clickComponent() {
    console.log('click sur le component');
  }

  public traitementDeLevenementDeTitre(message: Produit) {
    console.log('evenement recu:' + message);
    this.recupEvent = message;
  }
}

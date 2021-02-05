import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Produit } from 'src/model/produit';

@Component({
  selector: 'app-titre,[app-titre-attribut]',
  templateUrl: './titre.component.html',
  styleUrls: ['./titre.component.css'],
})
export class TitreComponent implements OnInit {
  @Input()
  titre: string;
  @Input('couleur')
  color: string = 'black';
  @Output('evenementDeclencheParLeComponentTitre')
  eventEmitter: EventEmitter<Produit> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {
    this.titre = this.titre.toUpperCase();
  }

  public declenchementDeLEventEmitter() {
    this.eventEmitter.emit(new Produit('tele', 1000));
  }
}

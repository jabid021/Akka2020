import { Produit } from './../../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formulaire-pilote-par-le-template',
  templateUrl: './formulaire-pilote-par-le-template.component.html',
  styleUrls: ['./formulaire-pilote-par-le-template.component.css'],
})
export class FormulairePiloteParLeTemplateComponent implements OnInit {
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}

  public submit() {
    console.log(this.produit);
  }
}

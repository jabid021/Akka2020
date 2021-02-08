import { ActivatedRoute, Router } from '@angular/router';
import { produits } from './../../../produits';
import { Produit } from './../../../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  private _produits: Produit[] = produits;

  constructor() {}

  ngOnInit(): void {}

  /**
   * Getter produits
   * @return {Produit[]}
   */
  public get produits(): Produit[] {
    return this._produits;
  }

  public delete(index: number) {
    this.produits.splice(index, 1);
  }
}

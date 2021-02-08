import { produits } from './../../../produits';
import { ActivatedRoute } from '@angular/router';
import { Produit } from './../../../../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'produit-row,[produit-row]',
  templateUrl: './produit-row.component.html',
  styleUrls: ['./produit-row.component.css'],
})
export class ProduitRowComponent implements OnInit {
  @Input('produit')
  private _produit: Produit = new Produit();
  private produitBeforeChange;
  private _produits: Produit[] = produits;
  private index: number = -1;
  consultation: boolean = true;

  constructor(private aR: ActivatedRoute) {
    aR.params.subscribe((params) => {
      if (params.index) {
        this.index = params.index;
      }
    });
  }

  ngOnInit(): void {
    this.produitBeforeChange = new Produit(
      this._produit.nom,
      this._produit.prix
    );
  }

  public delete() {
    this._produits.splice(this.index, 1);
  }

  /**
   * Getter produit
   * @return {Produit}
   */
  public get produit(): Produit {
    return this._produit;
  }

  /**
   * Setter produit
   * @param {Produit} value
   */
  public set produit(value: Produit) {
    this._produit = value;
  }

  public edit() {
    this.consultation = false;
  }

  public save() {
    this.consultation = true;
  }

  public cancel() {
    this._produit.nom = this.produitBeforeChange.nom;
    this._produit.prix = this.produitBeforeChange.prix;
    this.consultation = true;
  }
}

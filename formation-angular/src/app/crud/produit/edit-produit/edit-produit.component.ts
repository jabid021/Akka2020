import { produits } from './../../../produits';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from './../../../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-edit-produit',
  templateUrl: './edit-produit.component.html',
  styleUrls: ['./edit-produit.component.css'],
})
export class EditProduitComponent implements OnInit {
  private _produit: Produit = new Produit();
  private _produits: Produit[] = produits;
  private _index: number = -1;

  constructor(private aR: ActivatedRoute, private router: Router) {
    aR.params.subscribe((params) => {
      if (params.index) {
        this._index = params.index;
        this.produit = new Produit(
          this._produits[this._index].nom,
          this._produits[this._index].prix
        );
      }
    });
  }

  public save() {
    if (this._index === -1) {
      this._produits.push(this.produit);
    } else {
      this._produits[this._index] = this.produit;
    }
    this.navigate();
  }

  public cancel() {
    this.navigate();
  }

  private navigate() {
    this.router.navigate(['/produit']);
  }

  ngOnInit(): void {}

  /**
   * Getter produit
   * @return {Produit }
   */
  public get produit(): Produit {
    return this._produit;
  }

  /**
   * Setter produit
   * @param {Produit } value
   */
  public set produit(value: Produit) {
    this._produit = value;
  }
}

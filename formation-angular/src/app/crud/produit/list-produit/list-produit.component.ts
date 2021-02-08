import { FakeService } from './../../../service/fake.service';
import { ExempleService } from './../../../service/exemple.service';
import { ActivatedRoute, Router } from '@angular/router';
import { produits } from './../../../produits';
import { Produit } from './../../../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
  providers: [{ provide: ExempleService, useClass: FakeService }],
})
export class ListProduitComponent implements OnInit {
  private _produits: Produit[] = produits;

  constructor(private monService: ExempleService) {}

  ngOnInit(): void {
    this.monService.methodeDuService();
  }

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

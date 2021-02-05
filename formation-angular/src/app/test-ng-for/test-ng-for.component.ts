import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/model/produit';

@Component({
  selector: 'test-ng-for',
  templateUrl: './test-ng-for.component.html',
  styleUrls: ['./test-ng-for.component.css'],
})
export class TestNgForComponent implements OnInit {
  produits: Produit[] = [];

  constructor() {}

  ngOnInit(): void {}

  public info(p: Produit): string {
    let message: string = '';
    if (p.prix < 0) {
      message = 'Negatif';
    } else if (p.prix == 0) {
      message = 'Neutre';
    } else {
      message = 'Positif';
    }
    return message;
  }

  public ajout(p: Produit) {
    this.produits.push(p);
  }

  public delete(index: number) {
    this.produits.splice(index, 1);
  }
}

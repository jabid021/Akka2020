import { Component, OnInit } from '@angular/core';
import { Produit } from 'src/model/produit';

@Component({
  selector: 'test-ng-for',
  templateUrl: './test-ng-for.component.html',
  styleUrls: ['./test-ng-for.component.css'],
})
export class TestNgForComponent implements OnInit {
  produits: Produit[] = [
    new Produit('tele', 1000),
    new Produit('velo', 200),
    new Produit('velo', 200),
    new Produit('velo', 200),
  ];

  constructor() {}

  ngOnInit(): void {}
}

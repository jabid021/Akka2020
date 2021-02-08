import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  prenom: string = '';
  constructor(private activateRoute: ActivatedRoute) {
    this.activateRoute.params.subscribe(
      //traitements des parametres
      (params) => {
        //   setTimeout(() => {
        //     this.prenom = params.prenom;
        //   }, 5000);
        this.prenom = params.prenom;
      }
    );
  }

  ngOnInit(): void {}
}

import { Personne } from './../../../model/personne';
import { PersonneService } from './../../../service/personne.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-personne-list',
  templateUrl: './personne-list.component.html',
  styleUrls: ['./personne-list.component.css'],
})
export class PersonneListComponent implements OnInit {
  personnes: Personne[] = [];

  constructor(private personneService: PersonneService) {}

  ngOnInit(): void {
    this.initList();
  }

  public initList() {
    this.personneService.allPersonne().subscribe((data) => {
      this.personnes = data;
      console.log(data);
    });
  }
}

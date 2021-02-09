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
  showNew: boolean = false;

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

  public delete(id: number) {
    this.personneService.delete(id).subscribe((result) => {
      this.initList();
    });
  }

  public displayNew() {
    this.showNew = !this.showNew;
  }

  public insert() {
    this.displayNew();
    this.initList();
  }

  public cancel() {
    this.displayNew();
  }
}

import { Formation } from './../../../model/formation';
import { FormationService } from './../../../service/formation.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formation-list',
  templateUrl: './formation-list.component.html',
  styleUrls: ['./formation-list.component.css'],
})
export class FormationListComponent implements OnInit {
  formations: Formation[] = [];

  constructor(private formationService: FormationService) {}

  ngOnInit(): void {
    this.init();
  }

  public init() {
    this.formationService.findAll().subscribe((data) => {
      this.formations = data;
    });
  }

  public delete(id: number) {
    this.formationService.delete(id).subscribe((result) => {
      this.init();
    });
  }
}

import { FormationService } from './../../../service/formation.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Formation } from './../../../model/formation';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formation-edit',
  templateUrl: './formation-edit.component.html',
  styleUrls: ['./formation-edit.component.css'],
})
export class FormationEditComponent implements OnInit {
  formation: Formation = new Formation();

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private formationService: FormationService
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.formationService.findById(params.id).subscribe((data) => {
          this.formation = data;
        });
      }
    });
  }

  public save() {
    if (this.formation.id) {
      this.formationService.update(this.formation).subscribe((result) => {
        this.goList({ info: 'update' });
      });
    } else {
      this.formationService.insert(this.formation).subscribe((result) => {
        this.goList({ info: 'insert' });
      });
    }
  }

  private goList(info: Object) {
    this.router.navigate(['/formation'], { queryParams: info });
  }
}

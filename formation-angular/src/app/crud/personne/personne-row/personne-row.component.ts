import { PersonneService } from './../../../service/personne.service';
import { Personne } from './../../../model/personne';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'personne-row,[personne-row]',
  templateUrl: './personne-row.component.html',
  styleUrls: ['./personne-row.component.css'],
})
export class PersonneRowComponent implements OnInit {
  @Input()
  personne: Personne = new Personne();
  edit: boolean = false;
  @Output('delete')
  deleteEvent: EventEmitter<number> = new EventEmitter();
  @Output('insert')
  insertEvent: EventEmitter<void> = new EventEmitter();
  @Output('cancel')
  cancelEvent: EventEmitter<void> = new EventEmitter();

  constructor(private personneService: PersonneService) {}

  ngOnInit(): void {
    if (!this.personne.id) {
      this.changeMode();
    }
  }

  public delete() {
    this.deleteEvent.emit(this.personne.id);
  }

  public changeMode() {
    this.edit = !this.edit;
  }

  public cancel() {
    this.changeMode();
    if (!this.personne.id) {
      console.log('here');
      this.cancelEvent.emit();
    }
  }

  public save() {
    if (this.personne.id) {
      this.personneService.update(this.personne).subscribe((result) => {
        this.changeMode();
      });
    } else {
      this.personneService.insert(this.personne).subscribe((result) => {
        this.personne.id = result.id;
        this.changeMode();
        this.insertEvent.emit();
      });
    }
  }
}

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonneRowComponent } from './personne-row.component';

describe('PersonneRowComponent', () => {
  let component: PersonneRowComponent;
  let fixture: ComponentFixture<PersonneRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonneRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonneRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

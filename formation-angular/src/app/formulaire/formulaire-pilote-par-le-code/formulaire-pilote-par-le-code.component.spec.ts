import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulairePiloteParLeCodeComponent } from './formulaire-pilote-par-le-code.component';

describe('FormulairePiloteParLeCodeComponent', () => {
  let component: FormulairePiloteParLeCodeComponent;
  let fixture: ComponentFixture<FormulairePiloteParLeCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulairePiloteParLeCodeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulairePiloteParLeCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

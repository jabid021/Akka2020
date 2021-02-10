import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulairePiloteParLeTemplateComponent } from './formulaire-pilote-par-le-template.component';

describe('FormulairePiloteParLeTemplateComponent', () => {
  let component: FormulairePiloteParLeTemplateComponent;
  let fixture: ComponentFixture<FormulairePiloteParLeTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulairePiloteParLeTemplateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulairePiloteParLeTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

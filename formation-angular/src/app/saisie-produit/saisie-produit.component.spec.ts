import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaisieProduitComponent } from './saisie-produit.component';

describe('SaisieProduitComponent', () => {
  let component: SaisieProduitComponent;
  let fixture: ComponentFixture<SaisieProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaisieProduitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SaisieProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

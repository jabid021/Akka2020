import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Page1PublicComponent } from './page1-public.component';

describe('Page1PublicComponent', () => {
  let component: Page1PublicComponent;
  let fixture: ComponentFixture<Page1PublicComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Page1PublicComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Page1PublicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

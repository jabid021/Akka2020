import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonComponentComponent } from './mon-component.component';

describe('MonComponentComponent', () => {
  let component: MonComponentComponent;
  let fixture: ComponentFixture<MonComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MonComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MonComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

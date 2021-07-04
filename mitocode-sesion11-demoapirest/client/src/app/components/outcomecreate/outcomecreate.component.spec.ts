import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutcomecreateComponent } from './outcomecreate.component';

describe('OutcomecreateComponent', () => {
  let component: OutcomecreateComponent;
  let fixture: ComponentFixture<OutcomecreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutcomecreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutcomecreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

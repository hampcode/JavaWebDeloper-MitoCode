import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OutcomelistComponent } from './outcomelist.component';

describe('OutcomelistComponent', () => {
  let component: OutcomelistComponent;
  let fixture: ComponentFixture<OutcomelistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OutcomelistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OutcomelistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

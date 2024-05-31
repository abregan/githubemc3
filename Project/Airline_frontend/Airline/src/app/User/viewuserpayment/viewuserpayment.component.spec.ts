import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewuserpaymentComponent } from './viewuserpayment.component';

describe('ViewuserpaymentComponent', () => {
  let component: ViewuserpaymentComponent;
  let fixture: ComponentFixture<ViewuserpaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewuserpaymentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewuserpaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

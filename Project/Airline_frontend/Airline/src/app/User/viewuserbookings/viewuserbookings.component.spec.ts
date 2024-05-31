import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewuserbookingsComponent } from './viewuserbookings.component';

describe('ViewuserbookingsComponent', () => {
  let component: ViewuserbookingsComponent;
  let fixture: ComponentFixture<ViewuserbookingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewuserbookingsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewuserbookingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

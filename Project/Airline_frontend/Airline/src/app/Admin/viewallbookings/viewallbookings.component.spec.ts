import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewallbookingsComponent } from './viewallbookings.component';

describe('ViewallbookingsComponent', () => {
  let component: ViewallbookingsComponent;
  let fixture: ComponentFixture<ViewallbookingsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewallbookingsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewallbookingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

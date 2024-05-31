import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewallpaymentsComponent } from './viewallpayments.component';

describe('ViewallpaymentsComponent', () => {
  let component: ViewallpaymentsComponent;
  let fixture: ComponentFixture<ViewallpaymentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewallpaymentsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewallpaymentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

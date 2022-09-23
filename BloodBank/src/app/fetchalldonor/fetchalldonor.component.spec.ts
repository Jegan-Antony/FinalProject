import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchalldonorComponent } from './fetchalldonor.component';

describe('FetchalldonorComponent', () => {
  let component: FetchalldonorComponent;
  let fixture: ComponentFixture<FetchalldonorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FetchalldonorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FetchalldonorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

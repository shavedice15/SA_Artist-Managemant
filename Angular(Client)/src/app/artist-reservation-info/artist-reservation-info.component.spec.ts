import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistReservationInfoComponent } from './artist-reservation-info.component';

describe('ArtistReservationInfoComponent', () => {
  let component: ArtistReservationInfoComponent;
  let fixture: ComponentFixture<ArtistReservationInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArtistReservationInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtistReservationInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistReservationComponent } from './artist-reservation.component';

describe('ArtistReservationComponent', () => {
  let component: ArtistReservationComponent;
  let fixture: ComponentFixture<ArtistReservationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArtistReservationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtistReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

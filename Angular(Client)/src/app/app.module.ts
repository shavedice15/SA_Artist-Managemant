import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ArtistReservationComponent } from './artist-reservation/artist-reservation.component';
import { ArtistReservationInfoComponent } from './artist-reservation-info/artist-reservation-info.component';

import { QuereService } from './shared/quere/quere.service';

import { MatSelectModule } from '@angular/material/select';

const appRoutes: Routes = [
  {path: '',  redirectTo: '/artistReserv', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
//  {path: 'menu', component: MenuComponent},
  {path: 'artistReserv', component:  ArtistReservationComponent},
  {path: 'artistReservInfo', component:  ArtistReservationInfoComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ArtistReservationComponent,
    ArtistReservationInfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    MatSelectModule
  ],
  providers: [QuereService],
  bootstrap: [AppComponent]
})
export class AppModule { }

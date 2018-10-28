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
import { HomeComponent } from './home/home.component';
import { QuereService } from './shared/quere/quere.service';
import { LoginService } from './shared/login/login.service';
import { MatSelectModule } from '@angular/material/select';

import { RoutingMainModule } from "./routing-main/routing-main.module";
import { HomeCustomerComponent } from './home-customer/home-customer.component';
import { LoginManagerComponent } from './login-manager/login-manager.component';
import { HomeManagerComponent } from './home-manager/home-manager.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ArtistReservationComponent,
    ArtistReservationInfoComponent,
    HomeComponent,
    HomeCustomerComponent,
    LoginManagerComponent,
    HomeManagerComponent
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
    MatSelectModule,
    RoutingMainModule
  ],
  providers: [QuereService,LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }

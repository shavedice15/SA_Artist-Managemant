import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { ArtistReservationComponent } from '../artist-reservation/artist-reservation.component';
import { ArtistReservationInfoComponent } from '../artist-reservation-info/artist-reservation-info.component';
import { HomeComponent } from '../home/home.component';
import { HomeCustomerComponent } from '../home-customer/home-customer.component';
import { LoginManagerComponent } from '../login-manager/login-manager.component';
import { HomeManagerComponent } from '../home-manager/home-manager.component';

const routes: Routes = [
{path: '',  redirectTo: '/home', pathMatch: 'full'},
{path: 'home', component: HomeComponent},
{path: 'member/:username', component: HomeCustomerComponent},
{path: 'manager/:username', component: HomeManagerComponent},
{path: 'loginMember', component: LoginComponent},
{path: 'loginManager', component: LoginManagerComponent},
{path: 'artistReserv/:username', component:  ArtistReservationComponent},
{path: 'artistReservInfo/:username', component:  ArtistReservationInfoComponent},
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ],
  declarations: []
})
export class RoutingMainModule { }

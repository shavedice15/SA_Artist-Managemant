import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Router} from '@angular/router';
import {LoginService} from '../shared/login/login.service';

@Component({
  selector: 'app-home-customer',
  templateUrl: './home-customer.component.html',
  styleUrls: ['./home-customer.component.css']
})
export class HomeCustomerComponent implements OnInit {
  private customer :any;
  constructor(private route:ActivatedRoute, private router: Router, private loginService: LoginService) { }

  ngOnInit() {
    this.route.params.subscribe(prams=>{
        this.customer = prams
        console.log(prams)
      })
  }

  goReservation(){
    this.router.navigate(['artistReserv/' + this.customer.username,{username:this.customer.username}]);
  }

  logout() {
      this.router.navigate(['home']);
      console.log("Logout Success ")
  }
}

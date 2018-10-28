import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: any = {
    usernameCustomerLogin: '',
    passwordCustomerLogin: ''
  }
  customer:any={}

  constructor(private httpClient: HttpClient,private loginService: LoginService,private router: Router) {
    this.httpClient.request }

  ngOnInit() {
  }

  login() {
    this.loginService.getCustomer(this.user.usernameCustomerLogin).subscribe(data => {
      this.customer = data;
      if(data){
        if (data.password == this.user.passwordCustomerLogin) {
          this.loginService.setLoginCustomer(true);
          this.loginService.setUsernameCustomer(data.username);
          console.log("Login Success");
          this.router.navigate(['member/'+ data.username,{username:data.username}]);
        } else {
          alert('Invalid Password');
          console.log("Invalid Password");
        }
      } else {
           alert('Invalid Username');
          console.log("Invalid Username");
      }
    });
  }
  logout() {
    console.log("Logout : " + this.user.usernameCustomerLogin)
    if (this.loginService.isLoginCustomer()) {
      this.loginService.logoutCustomer();
      this.router.navigate(['home']);
      console.log("Logout Success ")
    }
  }

  goBack(){
    this.router.navigate(['home']);
  }
}

import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/login/login.service';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login-manager',
  templateUrl: './login-manager.component.html',
  styleUrls: ['./login-manager.component.css']
})
export class LoginManagerComponent implements OnInit {
  user: any = {
    usernameManagerLogin: '',
    passwordManagerLogin: ''
  }
  manager:any={}

  constructor(private httpClient: HttpClient,private loginService: LoginService,private router: Router) {
    this.httpClient.request }

  ngOnInit() {
  }

  login() {
    this.loginService.getManager(this.user.usernameManagerLogin).subscribe(data => {
      this.manager = data;
      if(data){
        if (data.password == this.user.passwordManagerLogin) {
          this.loginService.setLoginManager(true);
          this.loginService.setUsernameManager(data.username);
          console.log("Login Success");
          this.router.navigate(['manager',{username:data.username}]);
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
    console.log("Logout : " + this.user.usernameManagerLogin)
    if (this.loginService.isLoginManager()) {
      this.loginService.logoutManager();
      this.router.navigate(['home']);
      console.log("Logout Success ")
    }
  }
  goBack(){
    this.router.navigate(['home']);
  }
}

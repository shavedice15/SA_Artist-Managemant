import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  public API = '//localhost:8080';

  private loginCustomer:boolean = false;
  private loginManager:boolean = false;
  private usernameCustomer:string = '';
  private usernameManager:string = '';

  constructor(private http: HttpClient) { }

 setLoginCustomer(loginCustomer:boolean):void{
    this.loginCustomer = loginCustomer;
  }
  getUsernameCustomer():string{
    return this.usernameCustomer;
  }
  setUsernameCustomer(usernameCustomer:string){
     this.usernameCustomer = usernameCustomer;
  }
  isLoginCustomer():boolean {
    return this.loginCustomer;
  }
  logoutCustomer():void{
    this.usernameCustomer = '';
    this.setLoginCustomer(false);
  }
  getCustomer(username): Observable<any> {
    return this.http.get(this.API + '/Customer/user/' + username);
  }



  setLoginManager(loginManager:boolean):void{
    this.loginManager = loginManager;
  }
  getUsernameManager():string{
    return this.usernameManager;
  }
  setUsernameManager(usernameManager:string){
     this.usernameManager = usernameManager;
  }
  isLoginManager():boolean {
    return this.loginManager;
  }
  logoutManager():void{
    this.usernameManager = '';
    this.setLoginManager(false);
  }
  getManager(username): Observable<any> {
    return this.http.get(this.API + '/Manager/user/' + username);
  }

}

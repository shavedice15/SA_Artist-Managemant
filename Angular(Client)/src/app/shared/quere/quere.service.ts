import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QuereService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getTypeWork(): Observable<any> {
    return this.http.get(this.API + '/TypeWorks');
  }

  getBand(): Observable<any> {
    return this.http.get(this.API + '/Bands');
  }

  getStatus(): Observable<any> {
    return this.http.get(this.API + '/Status');
  }

  getPlace(): Observable<any> {
    return this.http.get(this.API + '/Places');
  }

  getCustomer(username): Observable<any> {
    return this.http.get(this.API + '/Customer/user/' + username);
  }

  getQueres(quereId): Observable<any> {
    return this.http.get(this.API + '/Quere/' + quereId);
  }
}

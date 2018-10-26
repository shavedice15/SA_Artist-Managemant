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

  getArtist(): Observable<any> {
    return this.http.get(this.API + '/Artists');
  }

  getStatus(): Observable<any> {
    return this.http.get(this.API + '/Status');
  }

  getPlace(): Observable<any> {
    return this.http.get(this.API + '/Places');
  }

  getUser(username): Observable<any> {
    return this.http.get(this.API + '/Customer/user/' + username);
  }

  getQueres(): Observable<any> {
    return this.http.get(this.API + '/Queres');
  }
}

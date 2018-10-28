import { Component, OnInit } from '@angular/core';
import { QuereService } from '../shared/quere/quere.service';
import { LoginService } from '../shared/login/login.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-artist-reservation',
  templateUrl: './artist-reservation.component.html',
  styleUrls: ['./artist-reservation.component.css']
})
export class ArtistReservationComponent implements OnInit {
  private customer :any;
  bands: Array<any>;
  typeWorks: Array<any>;
  user: any = {
    id : '',
    username : '',
    customerName : '',
    tel : '',
    email : ''
  };

  quereSet: any = {
    bandSelect : '',
    typeWorkSelect : ''
  }
  placeSet: any = {
    placeId : '',
    place : '',
    date : '',
    hour : '',
    hrs : '',
    mins : ''
  }
  Quere: any= {
    id: '',
    artistQuere: {},
    customerQuere: {},
    placeQuere: {},
    typeworkQuere: {},
    statusQuere: {}
  }


  constructor(private quereService:QuereService, private httpClient: HttpClient, private router: Router, private rout: ActivatedRoute,
    private loginService:LoginService) { }

  ngOnInit() {
    this.rout.params.subscribe(prams=>{
        this.customer = prams
        console.log(prams)
    })

    this.quereService.getBand().subscribe(data => {
      this.bands = data;
      console.log(this.bands);
    });

    this.quereService.getTypeWork().subscribe(data => {
      this.typeWorks = data;
      console.log(this.typeWorks);
    });

    this.quereService.getCustomer(this.customer.username).subscribe(data => {
      this.user = data;
      console.log(this.user);
    });
  }

  save() {

    if (this.quereSet.bandSelect === '' || this.quereSet.typeWorkSelect === '' || this.placeSet.place === '' || this.placeSet.date === '' ||
    this.placeSet.hour === '' || this.placeSet.hrs === '' || this.placeSet.mins === '') {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else {

      this.httpClient.post('http://localhost:8080/Place/new/' + this.placeSet.place + '/' + this.placeSet.date + '/' +
      this.placeSet.hour + '/' + this.placeSet.hrs + '/' + this.placeSet.mins,this.placeSet)
      .subscribe(
        data => {
          this.placeSet = data;
          console.log('PUT Request is successful', data);

          if(data){
            this.httpClient.post('http://localhost:8080/Quere/' + this.quereSet.bandSelect + '/' + this.user.username + '/' +
            this.quereSet.typeWorkSelect + '/' + this.placeSet.placeId,this.quereSet)
            .subscribe(
              data => {
                alert('การจองสำเร็จ');
                this.Quere = data;
                console.log('PUT Request is successful', data);
                if(data){
                  this.router.navigate(['artistReservInfo/' + this.customer.username,{username:this.customer.username, quereId:this.Quere.id}]);
                }
              },
              error => {
                console.log('Error', error);
              }
            );
          }

        },
        error => {
          console.log('Error', error);
        }
      );
    }

  }

  back(){
    this.router.navigate(['member/' + this.customer.username,{username:this.customer.username}]);
  }
}

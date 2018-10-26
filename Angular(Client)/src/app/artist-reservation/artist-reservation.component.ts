import { Component, OnInit } from '@angular/core';
import { QuereService } from '../shared/quere/quere.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-artist-reservation',
  templateUrl: './artist-reservation.component.html',
  styleUrls: ['./artist-reservation.component.css']
})
export class ArtistReservationComponent implements OnInit {

  artists: Array<any>;
  typeWorks: Array<any>;
  private username = 'kankan';
  user: any = {
    id : '',
    username : '',
    customerName : '',
    tel : '',
    email : ''
  };

  quereSet: any = {
    artistSelect : '',
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

  constructor(private quereService:QuereService, private httpClient: HttpClient, private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
    this.quereService.getArtist().subscribe(data => {
      this.artists = data;
      console.log(this.artists);
    });

    this.quereService.getTypeWork().subscribe(data => {
      this.typeWorks = data;
      console.log(this.typeWorks);
    });

    this.quereService.getUser(this.username).subscribe(data => {
      this.user = data;
      console.log(this.user);
    });
  }

  save() {

    if (this.quereSet.artistSelect === '' || this.quereSet.typeWorkSelect === '' || this.placeSet.place === '' || this.placeSet.date === '' ||
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
            this.httpClient.post('http://localhost:8080/Quere/' + this.quereSet.artistSelect + '/' + this.user.username + '/' +
            this.quereSet.typeWorkSelect + '/' + this.placeSet.placeId,this.quereSet)
            .subscribe(
              data => {
                alert('การจองสำเร็จ');
                console.log('PUT Request is successful', data);
                this.router.navigate(['artistReservInfo']);
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

}

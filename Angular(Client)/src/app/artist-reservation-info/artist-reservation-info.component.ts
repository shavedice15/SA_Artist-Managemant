import { Component, OnInit } from '@angular/core';
import { QuereService } from '../shared/quere/quere.service';
import { LoginService } from '../shared/login/login.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-artist-reservation-info',
  templateUrl: './artist-reservation-info.component.html',
  styleUrls: ['./artist-reservation-info.component.css']
})
export class ArtistReservationInfoComponent implements OnInit {
  private customer :any;

  user: any = {
    id : '',
    username : '',
    customerName : '',
    tel : '',
    email : ''
  };

  queres: Array<any>;
  artists: Array<any>;

  constructor(private quereService:QuereService, private httpClient: HttpClient, private router: Router, private rout: ActivatedRoute,
    private loginService:LoginService) { }

  ngOnInit() {
    this.rout.params.subscribe(prams=>{
        this.customer = prams
        console.log(prams)
    })
    this.quereService.getCustomer(this.customer.username).subscribe(data => {
      this.user = data;
      console.log(this.user);
    });
    this.quereService.getQueres(this.customer.quereId).subscribe(data => {
      this.queres = data;
      console.log(this.queres);
    });
  }

  cancel() {
    this.httpClient.post('http://localhost:8080/Quere/cancel/' + this.customer.quereId,this.customer)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
          this.router.navigate(['artistReservInfo/' + this.customer.username,{username:this.customer.username, quereId:this.customer.quereId}])
          alert('ยกเลิกการจองสำเร็จ โปรด Refresh หน้าจอ เพื่อ Update ข้อมูล');
        },
        error => {
          console.log('Error', error);
        }
      );
  }

  back(){
    this.router.navigate(['member/' + this.customer.username,{username:this.customer.username}]);
  }

}

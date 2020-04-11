import { Injectable } from '@angular/core';
import { Http, RequestOptions , Headers } from '@angular/http';  
import { Observable } from 'rxjs';  
import { AdminDetail } from '../classes/admin-detail';  
import { Router } from '@angular/router';  
  
import { JwtHelperService } from '@auth0/angular-jwt'; 

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  // Base URL  
  private  baseUrl = "http://localhost:8080/banks/";

  constructor(private http: Http, private router : Router) { }

  login(adminDetail : AdminDetail) : Observable<any>  
  {  
      let url = this.baseUrl + "login";  
      return this.http.post(url, adminDetail);  
  }  
}

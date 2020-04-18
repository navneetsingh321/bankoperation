import { Injectable } from '@angular/core';
import { Http, RequestOptions , Headers } from '@angular/http';  
import { Observable } from 'rxjs';  
import { Router } from '@angular/router';  
import { Login } from '../classes/login';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  private  baseUrl = "http://localhost:8080/banks/";

  constructor(private http: Http, private router : Router) { }

  signup(login : Login) : Observable<any>  
  {  
      let url = this.baseUrl + "signup";  
      return this.http.post(url, login);  
  }  

  getProfileDetails() : Observable<any>  
  {  
      let url = this.baseUrl + "signup/";  
      console.log(url)
      return this.http.get(url);  
  }  
}

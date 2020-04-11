import { Injectable } from '@angular/core';
import { Http, RequestOptions , Headers } from '@angular/http';  
import { Observable } from 'rxjs';  
import { Router } from '@angular/router';  
import { Login } from '../classes/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private  baseUrl = "http://localhost:8080/banks/";

  constructor(private http: Http, private router : Router) { }

  login(login : Login) : Observable<any>  
  {  
      let url = this.baseUrl + "login";  
      return this.http.post(url, login);  
  }  
}

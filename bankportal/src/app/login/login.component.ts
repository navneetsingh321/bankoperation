import { Component, OnInit } from '@angular/core';
import { Login } from '../classes/login';
import { LoginService } from '../services/login.service';  
import { Router } from '@angular/router';  
import { FormGroup, Validators, FormControl } from '@angular/forms';  

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private login = new Login();  

  constructor(private loginService : LoginService, private router : Router) { }

  ngOnInit(): void {
   // this.router.navigate(['/profile' , localStorage.getItem('id')]);  
  }

  form = new FormGroup({  
    username : new FormControl('' , Validators.required),  
    password : new FormControl('' , Validators.required)  
  });  

  Login(LoginInformation){
    this.login.username = this.username.value;
    this.login.password = this.password.value;
    console.log(this.login.username);
    console.log(this.login.password);
    this.loginService.login(this.login).subscribe(
      response => {  
        console.log("inside response")
        let result =  response.json();  
        alert(result.getItem)
       // if(result > 0){
          console.log("inside result if")
        this.router.navigate(['/profile']);
        //}
     
      },
      error => {  
        alert("credentials wrong.")  
      }  
    );
  }

  get username(){  
    return this.form.get('username');  
}  

get password(){  
    return this.form.get('password');  
}  

}

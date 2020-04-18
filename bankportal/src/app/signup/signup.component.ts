import { Component, OnInit } from '@angular/core';
import { Signup } from '../classes/signup';
import { SignupService } from '../services/signup.service';  
import { Router } from '@angular/router';  
import { FormGroup, Validators, FormControl } from '@angular/forms';  

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  private signup = new Signup();  

  constructor(private signupService : SignupService, private router : Router) { }

  ngOnInit(): void {
  }

  form = new FormGroup({  
    firstName : new FormControl('' , Validators.required),  
    lastName : new FormControl('' , Validators.required),  
    emailId : new FormControl('' , Validators.required),  
    username : new FormControl('' , Validators.required) , 
    password : new FormControl('' , Validators.required) , 
    confirmPassword : new FormControl('',Validators.required)
  });  

  Signup(signupInformation){
    this.signup.firstName = this.firstName.value;
    this.signup.lastName = this.lastName.value;
    this.signup.emailId = this.emailId.value;
    this.signup.username = this.username.value;
    this.signup.password = this.password.value;
    this.signup.confirmPassword = this.confirmPassword.value;
    this.signupService.signup(this.signup).subscribe(
      response => {  
        let result =  response.json();  
        alert("Signup successfull....")
        if(result > 0){
          console.log("inside result if")
        this.router.navigate(['/signup']);
       //alert("Signup successfull....")
        }
      },
      error => {  
        alert("something wrong")  
      }  

    );
  }

  get firstName(){
    return this.form.get("firstName");
  }

  get lastName(){
    return this.form.get("lastName");
  }
  
  get emailId(){
    return this.form.get("emailId");
  }

  get username(){
    return this.form.get("username");
  }

  get password(){
    return this.form.get("password");
  }

  get confirmPassword(){
    return this.form.get("confirmPassword");
  }

}

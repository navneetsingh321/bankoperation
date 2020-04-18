import { Component, OnInit } from '@angular/core';
import { SignupService } from '../services/signup.service';  
import { ActivatedRoute, Router } from '@angular/router'; 

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public signupId;  
  public haveData= 0;  
  
  public data = [];  
  
  public dataRequest = false;  
  
  constructor(private signupService  : SignupService, private route : ActivatedRoute, private router : Router) { } 

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {  
      this.signupId =+ params.get('id');  
    });  
  }

  getProfileData()  
  {  
      this.haveData = 0;  
  
      this.dataRequest = true;  
  
      this.signupService.getProfileDetails().subscribe(  
          response => {  
  
              let result = response.json(); 
              console.log(result) 
              this.data = result._embedded.item;  
  
              if(result == " ")  
              {  
                  this.haveData = 0;  
              }  
              else  
              {  
                this.haveData = this.haveData + 1;  
              }  
          },  
          error => {  
              alert("error while getting Signup Data");  
          }  
      );  
  }  

}

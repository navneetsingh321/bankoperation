import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';  
import { ReactiveFormsModule } from '@angular/forms';   
import { HttpModule} from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminService } from './services/admin.service';  

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
     ReactiveFormsModule,  
    HttpModule,  
    RouterModule.forRoot([  
      {  
        path : '',  
        component : HomeComponent   
      },  
      {  
        path : 'login',  
        component : LoginComponent    
      },  
      {  
        path : 'signup',  
        component : SignupComponent   
      },  
      {  
        path : 'profile',  
        component : ProfileComponent  
      }  
    ])  
  ],
  providers: [
    AdminService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

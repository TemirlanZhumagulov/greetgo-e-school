import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AuthService } from '../service/AuthService';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User =new User();

  constructor(private service: AuthService, private router: Router){}


  ngOnInit(): void {}

  login(){
    console.log(this.user);
    this.service.loginUser(this.user).subscribe(
      data => {
        console.log(data);
        alert("login successfully");
        this.router.navigate(['/home'], {queryParams: {username: this.user.username}});
      }, 
    error=>alert("please enter correct name and password"))
  }
  register(){
    this.service.registerUser(this.user).subscribe(
      data => {
        console.log(data);
        alert("registred successfully");
        this.router.navigate(['/home'], {queryParams: {username: this.user.username}});
    },
      error=>{
        console.log(error);
        alert("please enter correct name and password")}
        )
  }
}

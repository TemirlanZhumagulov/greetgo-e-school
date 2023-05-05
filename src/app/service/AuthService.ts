import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { User } from '../user';


@Injectable({  providedIn: 'root'})
export class AuthService{
    private baseUrl='http://localhost:8080/user';


    constructor(private http: HttpClient){}

    loginUser(user: User){
        return this.http.post(`${this.baseUrl}/login`, user);
    }
    registerUser(user: User){
        return this.http.post(`${this.baseUrl}/register`, user);
    }
}
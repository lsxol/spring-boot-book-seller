import {Injectable} from '@angular/core';
import {User} from "../models/user.model";
import {AuthenticationService} from "./authentication.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export abstract class RequestBaseService {
  protected currentUser: User = new User();

  constructor(private auth: AuthenticationService, protected http: HttpClient) {
    this.auth.currentUser.subscribe(user => {
      this.currentUser = user;
    });
  }

  get getHeaders(): HttpHeaders {
    return new HttpHeaders(
      {
        authorization: 'Bearer ' + this.currentUser?.token,
        "Content-Type": "application/json; charset=UTF-8"
      }
    )
  }
}

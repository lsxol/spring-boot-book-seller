import {Component} from '@angular/core';
import {User} from "./models/user.model";
import {AuthenticationService} from "./services/authentication.service";
import {Router} from "@angular/router";
import {Role} from "./models/role.enum";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Księgarnia internetowa';
  currentUser: User = new User;

  constructor(private authenticationService: AuthenticationService, private router: Router) {
    this.authenticationService.currentUser.subscribe(user => {
      this.currentUser = user;
    })
  }

  isAdmin() {
    return this.currentUser?.role === Role.ADMIN;
  }

  logOut() {
    this.authenticationService.logOut();
    this.router.navigate(['/login']);
  }
}

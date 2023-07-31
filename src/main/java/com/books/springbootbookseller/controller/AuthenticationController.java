package com.books.springbootbookseller.controller;

import com.books.springbootbookseller.model.User;
import com.books.springbootbookseller.service.IAuthenticationService;
import com.books.springbootbookseller.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authentication")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class AuthenticationController {

  @Autowired
  private IAuthenticationService authenticationService;

  @Autowired
  private UserService userService;

  @RequestMapping("sign-up")
  public ResponseEntity<User> signUp(@RequestBody User user) {
    userService.saveUser(user);
    authenticationService.signInAndReturnJwt(user);
    return ResponseEntity.ok(user);
  }
}

package com.books.springbootbookseller.service;

import com.books.springbootbookseller.model.User;

public interface IAuthenticationService {

  User signInAndReturnJwt(User user);
}

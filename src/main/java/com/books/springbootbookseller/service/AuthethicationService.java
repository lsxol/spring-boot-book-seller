package com.books.springbootbookseller.service;

import com.books.springbootbookseller.model.User;
import com.books.springbootbookseller.security.UserPrincipal;
import com.books.springbootbookseller.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
class AuthethicationService implements IAuthenticationService {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private IJwtProvider iJwtProvider;
  @Override
  public User signInAndReturnJwt(User user) {
    Authentication authentication =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
    String jwt = iJwtProvider.generateToken(userPrincipal);
    User signInUser = userPrincipal.getUser();
    signInUser.setToken(jwt);
    return signInUser;
  }

}

package com.books.springbootbookseller.security.jwt;

import com.books.springbootbookseller.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface IJwtProvider {

  String generateToken(UserPrincipal auth);

  Authentication getAuthentication(HttpServletRequest request);

  boolean validateToken(HttpServletRequest request);
}
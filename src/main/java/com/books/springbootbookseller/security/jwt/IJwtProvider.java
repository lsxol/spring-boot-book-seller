package com.books.springbootbookseller.security.jwt;

import com.books.springbootbookseller.security.UserPrincipal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface IJwtProvider {

  String generateToken(UserPrincipal userPrincipal);

  Authentication getAuthethication(HttpServletRequest request);

  boolean validateToken(HttpServletRequest request);
}

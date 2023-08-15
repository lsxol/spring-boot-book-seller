package com.books.springbootbookseller.security;


import com.books.springbootbookseller.util.SecurityUtils;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class InternalApiAuthenticationFilter extends OncePerRequestFilter {

  private final String accessKey;

  public InternalApiAuthenticationFilter(String accessKey) {
    this.accessKey = accessKey;
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return !request.getRequestURI().startsWith("/api/internal");
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      String requestKey = SecurityUtils.extractAuthTokenFromRequest(request);
      if (requestKey == null || !requestKey.equals(accessKey)) {
        logger.warn("Internal key endpoint requested without/wrong key uri: " + request.getRequestURI());
        throw new RuntimeException("UNAUTHORIZED");
      }
      UserPrincipal userPrincipal = UserPrincipal.createSuperUser();
      UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null,
          userPrincipal.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    } catch (Exception e) {
      logger.error("Could not set user authentication in security context", e);
    }
    filterChain.doFilter(request, response);
  }
}

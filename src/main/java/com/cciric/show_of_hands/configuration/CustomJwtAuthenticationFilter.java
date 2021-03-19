package com.cciric.show_of_hands.configuration;

import com.cciric.show_of_hands.service.service.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtilToken;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //jwt token is in the form "bearer token". Remove bearer word and get only token
        String jwtToken = extractJwtFromRequest(httpServletRequest);

        if(StringUtils.hasText(jwtToken) && jwtUtilToken.validateToken(jwtToken)){
            UserDetails userDetails = new User(jwtUtilToken.getUsernameFromToken(jwtToken), "", jwtUtilToken.getRolesFromToken(jwtToken));

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null,
                            userDetails.getAuthorities());
            //after setting the authentication in the context, we specify that the current
            //user is authenticated. so it passes the spring security configurations successfully
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        } else {
            System.out.print("Cannon set the security context");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String extractJwtFromRequest(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}

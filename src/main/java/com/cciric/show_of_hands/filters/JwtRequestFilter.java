package com.cciric.show_of_hands.filters;

import com.cciric.show_of_hands.service.MyUserDetailsService;
import com.cciric.show_of_hands.utl.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    
    private MyUserDetailsService userDetailsService;

    @Autowired
    public JwtRequestFilter(@Qualifier("userDetailsServ") MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //if finds valid jwt, get the user details from this,
    final String authorizationHeader = httpServletRequest.getHeader("Authorization");

    String username = null;
    String jwt = null;

    if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
        jwt = authorizationHeader.substring(7);
        username = jwtUtil.extractUsername(jwt);
    }

    else {
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        return;
    }

    if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

        if(jwtUtil.validateToekn(jwt, userDetails)){
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource()
            .buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    }

}

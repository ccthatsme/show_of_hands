package com.cciric.show_of_hands.service.service;

import com.cciric.show_of_hands.data.entity.Role.Role;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

@Service
public class JwtUtil {

    private String secret;
    private int jwtExpirationInMs;

    @Value("${jwt.secret}")
    public void setSecret(String secret){
        this.secret = secret;
    }

    @Value("${jwt.expirationDateInMs}")
    public void setJwtExpirationInMs(int jwtExpirationInMs){
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    //generate token for user
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

        for (GrantedAuthority role: roles) {
            role.getAuthority();
        }

        if(roles.contains(new SimpleGrantedAuthority("READ_PRIVILEGE")) && roles.contains(new SimpleGrantedAuthority("WRITE_PRIVILEGE"))){
            claims.put("isAdmin", true);
        }
        if(!roles.contains(new SimpleGrantedAuthority("WRITE_PRIVILEGE"))){
            claims.put("isUser", true);
        }

//        if(roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
//            claims.put("isAdmin", true);
//        }
//        if(roles.contains(new SimpleGrantedAuthority("ROLE_USER"))){
//            claims.put("isUser", true);
//        }

        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String username) {
        return Jwts.builder().setClaims(claims).setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public boolean validateToken(String authToken){

        Jws<Claims> claims = null;

        try{
            //JWT token has not been tampered with
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;

        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e){
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        } catch (ExpiredJwtException ex) {
            throw new ExpiredJwtException(claims.getHeader(), (Claims) claims, "Token has expired", ex);
        }
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public List<SimpleGrantedAuthority> getRolesFromToken(String authToken) {
        List<SimpleGrantedAuthority> roles = null;
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken).getBody();
        Boolean isAdmin = claims.get("isAdmin", Boolean.class);
        Boolean isUser = claims.get("isUser", Boolean.class);

        if(isAdmin != null && isAdmin == true){
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        if(isUser != null && isUser == true){
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return roles;
    }



}

package com.cciric.show_of_hands.controller;

import com.cciric.show_of_hands.models.AuthenticationRequest;
import com.cciric.show_of_hands.models.AuthenticationResponse;
import com.cciric.show_of_hands.models.BasePoll;
import com.cciric.show_of_hands.service.MyUserDetailsService;
import com.cciric.show_of_hands.utl.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private LoginService loginService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

//    @GetMapping(value = "/login")
//    public String getAllPollsForUser(@RequestParam("userId") int userId){
//        return loginService.getAllPollsForUser(userId);
//    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
       try {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                   authenticationRequest.getUsername(), authenticationRequest.getPassword()
           ));
       } catch (BadCredentialsException e){
           throw new Exception("Incorrect username or password", e);
       }
       final UserDetails userDetails = userDetailsService.loadUserByUsername(
               authenticationRequest.getUsername()
       );
       final String jwt = jwtTokenUtil.generateToken(userDetails);

       return ResponseEntity.ok(new AuthenticationResponse(jwt));
    };
}

package com.cciric.show_of_hands.service;

import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.data.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("userDetailsServ")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
      //  UserEntity user = userRepo.findByUserName(userName);
      //  return new User(user.getUserName(), user.getPassword(), new ArrayList<>());
        return new User("foo", "bar", new ArrayList<>()) {
        };
    }
}

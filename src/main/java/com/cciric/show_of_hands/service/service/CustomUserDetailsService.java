package com.cciric.show_of_hands.service.service;

import com.cciric.show_of_hands.data.entity.Privilege.Privilege;
import com.cciric.show_of_hands.data.entity.Role.Role;
import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.data.repository.RoleRepository;
import com.cciric.show_of_hands.data.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MessageSource messageSource;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        UserEntity user = userRepo.findByUserName(username);
//
//        return new User(user.getUserName(), user.getPassword(), new ArrayList<>());

//        List<SimpleGrantedAuthority> roles = null;
//
//        if(username.equals("admin")){
//            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
//            return new User("admin", "$2y$12$I0Di/vfUL6nqwVbrvItFVOXA1L9OW9kLwe.1qDPhFzIJBpWl76PAe", roles);
//        }
//        else if (username.equals("user")){
//            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//            return new User("user", "$2y$12$VfZTUu/Yl5v7dAmfuxWU8uRfBKExHBWT1Iqi.s33727NoxHrbZ/h2", roles);
//        }
//        throw new UsernameNotFoundException("User not found with username: " + username);
   // }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByUserName(username);

        if(userEntity == null){
            return new User(" ", " ", true, true, true, true,
                    getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        }

        return new User(userEntity.getEmail(), userEntity.getPassword(), userEntity.isEnabled(), true, true, true,
                getAuthorities(userEntity.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege: privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    private List<String> getPrivileges(Collection<Role> roles){
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();

        for ( Role role: roles) {
            collection.addAll(role.getPrivileges());
        }

        for ( Privilege item: collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

}

package com.cciric.show_of_hands.service.service;

import com.cciric.show_of_hands.data.entity.Privilege.Privilege;
import com.cciric.show_of_hands.data.entity.Role.Role;
import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.data.repository.PrivilegeRepository;
import com.cciric.show_of_hands.data.repository.RoleRepository;
import com.cciric.show_of_hands.data.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup){
            return;
        }
        
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);

        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("Test");
        userEntity.setPassword(passwordEncoder.encode("test"));
        userEntity.setEmail("test@test.com");
        userEntity.setRoles(Arrays.asList(adminRole));
        userEntity.setEnabled(true);
        userRepo.save(userEntity);

        alreadySetup = true;


    }

    @Transactional
    private Role createRoleIfNotFound(String role_admin, List<Privilege> adminPrivileges) {
        Role role = roleRepository.findByName(role_admin);

        if(role == null){
            role = new Role(role_admin);
            role.setPrivileges(adminPrivileges);
            roleRepository.save(role);
        }
        return role;
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String read_privilege) {
        Privilege privilege = privilegeRepository.findByName(read_privilege);
        if(privilege == null){
            privilege = new Privilege(read_privilege);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

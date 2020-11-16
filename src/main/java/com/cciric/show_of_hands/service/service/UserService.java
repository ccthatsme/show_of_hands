package com.cciric.show_of_hands.service.service;

import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.data.repository.UserRepo;
import com.cciric.show_of_hands.models.User;
import com.cciric.show_of_hands.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    UserMapper userMapper;

    public User createUser(UserEntity entity){

        userRepo.save(entity);

        return userMapper.entityToModel(entity);

    }

}

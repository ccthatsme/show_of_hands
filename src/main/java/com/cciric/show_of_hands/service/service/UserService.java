package com.cciric.show_of_hands.service.service;

import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.data.repository.UserRepo;
import com.cciric.show_of_hands.models.User;
import com.cciric.show_of_hands.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<User> getAllUsers() {
        List<UserEntity> entityList = userRepo.findAll();
        List<User> modelList = new ArrayList<>();

        entityList.stream().forEach(entity -> {
            modelList.add(userMapper.entityToModel(entity));
        });
        return modelList;
    }

    public User getUser(int id) {
        UserEntity entity = userRepo.getOne(id);

        return userMapper.entityToModel(entity);
    }

    public void saveUser(UserEntity userEntity) {
        userRepo.saveAndFlush(userEntity);
    }
}

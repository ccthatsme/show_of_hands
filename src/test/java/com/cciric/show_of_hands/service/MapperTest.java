package com.cciric.show_of_hands.service;

import com.cciric.show_of_hands.data.entity.Entities;
import com.cciric.show_of_hands.data.entity.UserEntity;
import com.cciric.show_of_hands.models.Models;
import com.cciric.show_of_hands.models.User;
import com.cciric.show_of_hands.service.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MapperTest {

    @Autowired
    UserMapper um;

    UserEntity userEntity;

    User userModel;

    private Models models = new Models();

    @BeforeAll
    public void before(){

    userEntity = Entities.userEntityCreation();
    userModel = models.userCreation();
}

    @Test
    public void nonNull(){
        Assertions.assertNotNull(userEntity, "user entity was null");
        Assertions.assertNotNull(userModel, "user model was null");

    }


}

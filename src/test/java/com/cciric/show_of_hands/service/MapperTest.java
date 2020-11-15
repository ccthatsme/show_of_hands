package com.cciric.show_of_hands.service;

import com.cciric.show_of_hands.service.mapper.UserMapper;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MapperTest {

    @Autowired
    UserMapper um;


}

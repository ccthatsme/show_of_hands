package com.cciric.show_of_hands.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cciric.show_of_hands.models.Models;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModelsTest {



    private Models models = new Models();


    private ThreeChoicePoll threeChoicePoll = new ThreeChoicePoll();

@BeforeAll
    public void before(){
    threeChoicePoll = models.threeChoicePollCreation();
}

@Test
    public void notNull(){
    Assertions.assertNotNull(threeChoicePoll);
}

}

package com.cciric.show_of_hands.models;

import com.cciric.show_of_hands.data.entity.BasePollEntity;
import com.cciric.show_of_hands.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Models {

    Random rand = new Random();

//    @Autowired
//    public BasePoll threeChoicePoll;

    public int id = rand.nextInt();
    public String questionOne = "what should I bring to the party?";
    public String choiceOne = "liquor";
    public int resultOne = rand.nextInt(54);
    public String choiceTwo = "cake";
    public String choiceThree = "cookies";

    public int resultTwo  = rand.nextInt(54);
    public int resultThree  = rand.nextInt(54);
    public User user;

    private String userName = "chris";
    private String email = "chris@yahoo.com";
    private String password = "pass";

    private Set<BasePollEntity> list = new HashSet<>();

    public ThreeChoicePoll threeChoicePollCreation(){
        ThreeChoicePoll threeChoicePoll = new ThreeChoicePoll();
        threeChoicePoll.setId(id);
        threeChoicePoll.setQuestion(questionOne);
        threeChoicePoll.setChoiceOne(choiceOne);
        threeChoicePoll.setChoiceTwo(choiceTwo);
        threeChoicePoll.setChoiceThree(choiceThree);
        threeChoicePoll.setResultOne(resultOne);
        threeChoicePoll.setResultTwo(resultTwo);
        threeChoicePoll.setResultThree(resultThree);
        return threeChoicePoll;
    }

    public User userCreation(){
        User user = new User();

        int userId = rand.nextInt();

        user.setId(userId);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);

        return user;

    }

}

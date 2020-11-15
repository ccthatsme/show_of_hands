package com.cciric.show_of_hands.data.entity;

import com.cciric.show_of_hands.models.ThreeChoicePoll;
import com.cciric.show_of_hands.models.User;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Entities {

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


    public ThreeChoicePollEntity threeChoicePollEntityCreation(){
        ThreeChoicePollEntity threeChoicePoll = new ThreeChoicePollEntity();
        threeChoicePoll.setId(id);
        threeChoicePoll.setQuestion(questionOne);
        threeChoicePoll.setChoiceOne(choiceOne);
        threeChoicePoll.setChoiceTwo(choiceTwo);
        threeChoicePoll.setChoiceThree(choiceThree);
        threeChoicePoll.setResultOne(resultOne);
        threeChoicePoll.setResultTwo(resultTwo);
        threeChoicePoll.setResultThree(resultThree);
        threeChoicePoll.setUser(userEntityCreation());
        return threeChoicePoll;
    }

    public UserEntity userEntityCreation(){
        UserEntity userEntity = new UserEntity();

        int userId = rand.nextInt();

        userEntity.setId(userId);
        userEntity.setUserName(userName);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setPollList(list);

        return userEntity;

    }


}

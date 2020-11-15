package com.cciric.show_of_hands.data.entity;

import com.cciric.show_of_hands.models.ThreeChoicePoll;
import com.cciric.show_of_hands.models.User;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Entities {

   public static Random rand = new Random();

//    @Autowired
//    public BasePoll threeChoicePoll;

    public static int id = rand.nextInt();
    public static String questionOne = "what should I bring to the party?";
    public static String choiceOne = "liquor";
    public static int resultOne = rand.nextInt(54);
    public static String choiceTwo = "cake";
    public static String choiceThree = "cookies";

    public static int resultTwo  = rand.nextInt(54);
    public static int resultThree  = rand.nextInt(54);
    public static User user;

    private static String userName = "chris";
    private static String email = "chris@yahoo.com";
    private static String password = "pass";

    private static Set<BasePollEntity> list = new HashSet<>();


    public static ThreeChoicePollEntity threeChoicePollEntityCreation(){
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

    public static UserEntity userEntityCreation(){
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

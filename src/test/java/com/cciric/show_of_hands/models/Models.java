package com.cciric.show_of_hands.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

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

}

package com.cciric.show_of_hands.models;

public class ThreeChoicePoll extends BasePoll{

    private String choiceTwo;
    private String choiceThree;

    private int resultTwo;
    private int resultThree;



    public String getChoiceTwo() {
        return choiceTwo;
    }

    public void setChoiceTwo(String choiceTwo) {
        this.choiceTwo = choiceTwo;
    }

    public String getChoiceThree() {
        return choiceThree;
    }

    public void setChoiceThree(String choiceThree) {
        this.choiceThree = choiceThree;
    }

    public int getResultTwo() {
        return resultTwo;
    }

    public void setResultTwo(int resultTwo) {
        this.resultTwo = resultTwo;
    }

    public int getResultThree() {
        return resultThree;
    }

    public void setResultThree(int resultThree) {
        this.resultThree = resultThree;
    }
}

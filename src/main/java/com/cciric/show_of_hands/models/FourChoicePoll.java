package com.cciric.show_of_hands.models;

public class FourChoicePoll extends BasePoll{

    private String choiceTwo;
    private String choiceThree;
    private String choiceFour;

    private int resultTwo;
    private int resultThree;
    private int resultFour;

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

    public String getChoiceFour() {
        return choiceFour;
    }

    public void setChoiceFour(String choiceFour) {
        this.choiceFour = choiceFour;
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

    public int getResultFour() {
        return resultFour;
    }

    public void setResultFour(int resultFour) {
        this.resultFour = resultFour;
    }
}

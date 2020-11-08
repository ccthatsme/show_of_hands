package com.cciric.show_of_hands.data.entity;

import javax.persistence.Column;

public class FourChoicePollEntity extends BasePollEntity{


    @Column(name = "choice_two")
    private String choiceTwo;
    @Column(name = "choice_three")
    private String choiceThree;
    @Column(name = "choice_four")
    private String choiceFour;
    @Column(name = "result_two")
    private int resultTwo;
    @Column(name = "result_three")
    private int resultThree;
    @Column(name = "result_four")
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

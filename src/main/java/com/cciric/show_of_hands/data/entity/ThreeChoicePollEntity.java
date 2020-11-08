package com.cciric.show_of_hands.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ThreeChoicePoll")
public class ThreeChoicePollEntity  extends BasePollEntity{

    @Column(name = "choice_two")
    private String choiceTwo;
    @Column(name = "choice_three")
    private String choiceThree;
    @Column(name = "result_two")
    private int resultTwo;
    @Column(name = "result_three")
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

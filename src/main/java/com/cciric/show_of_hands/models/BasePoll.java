package com.cciric.show_of_hands.models;

public abstract class BasePoll {

    public static final String SHOW_OF_HANDS = "Show of hands ";

    public int id;
    public String question;
    public String choiceOne;
    public int resultOne;
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = SHOW_OF_HANDS + question;
    }

    public String getChoiceOne() {
        return choiceOne;
    }

    public void setChoiceOne(String choiceOne) {
        this.choiceOne = choiceOne;
    }

    public int getResultOne() {
        return resultOne;
    }

    public void setResultOne(int resultOne) {
        this.resultOne = resultOne;
    }
}

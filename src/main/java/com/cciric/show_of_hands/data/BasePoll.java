package com.cciric.show_of_hands.data;

import com.cciric.show_of_hands.models.User;

import javax.persistence.*;

@Entity
@Table(name = "BasePoll")
@MappedSuperclass
public class BasePoll {

    public static final String SHOW_OF_HANDS = "Show of hands ";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int id;

    @Column(name = "question", nullable = false)
    public String question;

    @Column(name = "choice_one", nullable = false)
    public String choiceOne;

    @Column(name = "result_one", nullable = true)
    public int resultOne;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    public User user;

    public static String getShowOfHands() {
        return SHOW_OF_HANDS;
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
        this.question = question;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

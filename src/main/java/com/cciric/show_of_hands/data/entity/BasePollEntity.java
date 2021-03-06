package com.cciric.show_of_hands.data.entity;


import javax.persistence.*;
import java.util.Objects;


@Table(name = "BasePoll")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BasePollEntity {

    public static final String SHOW_OF_HANDS = "Show of hands ";

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", unique = true, nullable = false)
    public int id;


    @Column(name = "question", nullable = false)
    public String question;

    @Column(name = "choice_one", nullable = false)
    public String choiceOne;

    @Column(name = "result_one", nullable = true)
    public int resultOne;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    public UserEntity user;

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasePollEntity)) return false;
        BasePollEntity that = (BasePollEntity) o;
        return id == that.id &&
                resultOne == that.resultOne &&
                question.equals(that.question) &&
                choiceOne.equals(that.choiceOne) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, choiceOne, resultOne, user);
    }
}

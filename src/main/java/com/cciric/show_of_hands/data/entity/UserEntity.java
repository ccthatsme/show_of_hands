package com.cciric.show_of_hands.data.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<BasePollEntity> pollList = new HashSet<>();

    public UserEntity(int id, String userName, String email, String password, Set<BasePollEntity> pollList) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.pollList = pollList;
    }

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<BasePollEntity> getPollList() {
        return pollList;
    }

    public void setPollList(Set<BasePollEntity> pollList) {
        this.pollList = pollList;
    }
}

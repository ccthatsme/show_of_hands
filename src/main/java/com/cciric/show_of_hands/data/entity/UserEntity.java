package com.cciric.show_of_hands.data.entity;


import com.cciric.show_of_hands.data.entity.Role.Role;

import javax.persistence.*;
import java.util.Collection;
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

    //not sure what I am going to do with these just yet
    private boolean enabled;
    private boolean tokenExpired;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<BasePollEntity> pollList = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns =
    @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id",
    referencedColumnName = "id"))
    private Collection<Role> roles;

    public UserEntity(int id, String userName, String email, String password, Set<BasePollEntity> pollList, Collection<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.pollList = pollList;
        this.roles = roles;
    }

    public UserEntity() {
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
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

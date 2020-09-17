package com.example.Bandproject.models;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")// This tells Hibernate to make a table out of this class
public class User {
    public User() {

    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String role;


    private String instrument;
    private boolean enabled;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//    @OneToMany(cascade = CascadeType.ALL)
//    List<UserAuthorities> authorities = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

//    public List<UserAuthorities> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(List<UserAuthorities> authorities) {
//        this.authorities = authorities;
//    }
//
//    public void addAuthorities(String authority){
//        this.authorities.add(new UserAuthorities(this, authority));
//    }
}
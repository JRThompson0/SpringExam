package com.cohort15.SpringExam.Models;

import com.cohort15.SpringExam.Models.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private long id;
    @NotBlank(message = "username must not be blank!")
    @Column(unique = true, name="USERNAME")
    private String username;
    @Column(name="GENDER")
    private Gender gender;

    public User(String username, Gender gender) {
        this.username = username;
        this.gender = gender;
    }
    public User(String username) {
        this.username=username;
    }
    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

package com.cohort15.SpringExam.Models;

import jakarta.persistence.*;

import javax.swing.text.AbstractDocument;
@Entity
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name="USER_ID")
    private User postMaker;

    private String title;

    @OneToOne
    @JoinColumn(name="CONTENT_ID")
    private Content content;
}

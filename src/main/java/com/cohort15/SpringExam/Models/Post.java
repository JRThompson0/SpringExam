package com.cohort15.SpringExam.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import javax.swing.text.AbstractDocument;
@Entity
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User postMaker;
    @NotEmpty(message = "Post must be titled!")
    private String title;
    @NotEmpty(message = "Post must have content!")
    @OneToOne
    @JoinColumn(name="CONTENT_ID")
    private Content content;
    public boolean isEmpty()
    {
        return postMaker == null;
    }
}

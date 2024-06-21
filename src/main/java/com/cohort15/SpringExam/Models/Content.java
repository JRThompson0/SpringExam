package com.cohort15.SpringExam.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
@Entity
public class Content
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CONTENT_ID")
    private long id;
    @OneToOne
    @NotNull
    @JoinColumn(name="POST_ID")
    Post post;

    private String message;
    private Object data;
}

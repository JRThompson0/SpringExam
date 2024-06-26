package com.cohort15.SpringExam.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMMENT_ID")
    private long ID;
    @NotBlank
    private String message;
    @ManyToOne
    @NotNull
    @JoinColumn(name="CONTENT_ID")
    private Content commentedUponObject;
}

package com.webpro.virtual_learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
@Getter
@Setter
public class QuestionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "option", columnDefinition = "TEXT")
    private String option;

    @Column(name = "correct")
    private Integer correct;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonEntity lesson;

    @ManyToMany(mappedBy = "doneQuestions")
    List<UserEntity> users = new ArrayList<>();
}

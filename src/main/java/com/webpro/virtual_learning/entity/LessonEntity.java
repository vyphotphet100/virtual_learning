package com.webpro.virtual_learning.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
@Getter
@Setter
public class LessonEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "video")
    private String video;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity clazz;

    @OneToMany(mappedBy = "lesson")
    private List<QuestionEntity> questions = new ArrayList<>();

}

package com.webpro.virtual_learning.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
@Getter
@Setter
public class LessonEntity extends BaseEntity{
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
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<QuestionEntity> questions = new ArrayList<>();

}

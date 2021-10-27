package com.webpro.virtual_learning.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "class")
@Getter @Setter
public class ClassEntity extends BaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "author_username")
    private UserEntity authorUser;

    @ManyToMany(mappedBy = "joinedClasses")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserEntity> joinedUser = new ArrayList<>();

    @OneToMany(mappedBy = "clazz")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<LessonEntity> lessons = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;
}

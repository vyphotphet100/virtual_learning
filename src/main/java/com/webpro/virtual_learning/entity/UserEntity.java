package com.webpro.virtual_learning.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity extends BaseEntity{
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "avatar")
    private String avatar;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @OneToMany(mappedBy = "authorUser")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ClassEntity> createdClasses = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "joined",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ClassEntity> joinedClasses = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "do",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<QuestionEntity> doneQuestions = new ArrayList<>();
}

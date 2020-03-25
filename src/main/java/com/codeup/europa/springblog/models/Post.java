package com.codeup.europa.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @ManyToOne
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable = false,length = 100, unique = true)
    private String title;

    @Column(length = 1000, nullable = false)
    private String body;

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
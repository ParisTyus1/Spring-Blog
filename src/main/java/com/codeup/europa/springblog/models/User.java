package com.codeup.europa.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {


    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;


    public User() {
    }

    public User(User copy){
        id= copy.id;
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

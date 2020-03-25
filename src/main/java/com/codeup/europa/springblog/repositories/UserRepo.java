package com.codeup.europa.springblog.repositories;

import com.codeup.europa.springblog.models.Post;
import com.codeup.europa.springblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    public User findUserById(long id);
    User findByUsername(String username);
}

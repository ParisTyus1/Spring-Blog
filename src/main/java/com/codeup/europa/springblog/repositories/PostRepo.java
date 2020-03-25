package com.codeup.europa.springblog.repositories;

import com.codeup.europa.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository <Post, Long> {

 Post findById(long id);
 Post findByTitle(String title);
//    public Post deleteById(long id);
//    List<Post> findByOrderByTitle();
//
//    Post findByTitle(String title);
//
//    @Query("from Post a where a.id like ?1")
//    Post getPostById(long id);
//
//    @Query("select title from Post where length(title) < 20")
//    List<String> getPostOfCertainTitleLength();
//
//    @Query(nativeQuery = true, value = "SELECT title FROM post WHERE LENGTH(title) < 10")
//    List<String> getPostOfCertainTitleLengthNative();
//
//    @Query("from Post a where a.id like ?1")
//    Post delete(long id);

}
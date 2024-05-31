package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();
    Post findById(long id);
    void save(Post p);
    void delete(long id);
    void update(long id, Post p);


}





//=============== class demo=========================
//    public Post findPostByPriceGreaterThan(double price);
//    public List<Post> findPostByCategory(String cat);
//    @Query("select p.reviews from Product p where p.id = :val")
//    public List<Review> someWierdStuff(@Param("val") double val);
//
//    @Query("select p from product p where size(p.reviews) >= :num")


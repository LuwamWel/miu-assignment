package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByTitleContaining(String title);

}

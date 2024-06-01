
package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo{
    private static List<Post> posts;

    static {
        posts = new ArrayList<>();
        Post post1 = new Post(1, "First Post", "First post content", "John Doe");
        Post post2 = new Post(2, "Second Post", "Second post content", "Jane Smith");
        Post post3 = new Post(3, "Third Post", "Third post content", "Michael Jordan");

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

    }
    @Override
    public List<Post> findAll() {
        return posts;
    }
    @Override
    public void save(Post p){
        posts.add(p);
    }

    @Override
    public Post findById(long id){
        return posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(long id) {
        posts.removeIf(post -> post.getId() == id);
    }

    @Override
    public void updatePostById(long id, Post p) {
        posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .ifPresent(post -> {
                    post.setId(p.getId());
                    post.setAuthor((p.getAuthor()));
                    post.setContent(p.getContent());
                    post.setTitle(p.getTitle());
                });
    }
}



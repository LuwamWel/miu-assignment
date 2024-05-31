package edu.miutest.demo.repo;

import edu.miutest.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepoImpl implements UserRepo {
    private static List<User> users = new ArrayList<>();
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void delete(long id) {
        users.removeIf(user -> user.getId() == id);
    }

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Post> findPostByUserId(long userId) {
//        User user = entityManager.find(User.class, userId);
//        if (user != null) {
//            return user.getPosts();
//        } else {
//            return null;
//        }
//    }

}

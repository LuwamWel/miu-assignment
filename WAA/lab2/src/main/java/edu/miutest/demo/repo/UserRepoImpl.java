package edu.miutest.demo.repo;

import edu.miutest.demo.entity.Userr;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepoImpl implements UserRepo {
    private static List<Userr> users = new ArrayList<>();
    @Override
    public List<Userr> findAll() {
        return users;
    }

    @Override
    public Userr findById(long id) {
        return users.stream()
                .filter(usr -> usr.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Userr usr) {
        users.add(usr);
    }

    @Override
    public void delete(long id) {
        users.removeIf(usr -> usr.getId() == id);
    }

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Post> findPostByUserId(long userId) {
//        User usr = entityManager.find(Userr.class, userId);
//        if (usr != null) {
//            return usr.getPosts();
//        } else {
//            return null;
//        }
//    }

}
